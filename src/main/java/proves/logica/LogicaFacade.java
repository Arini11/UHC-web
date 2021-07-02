package proves.logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheetView;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSheetViewType;
import org.apache.poi.util.IOUtils;

import com.spire.xls.FileFormat;
import com.spire.xls.Workbook;

import proves.connexio.Connexio;
import proves.objectes.Jugador;
import proves.objectes.Usuari;

public class LogicaFacade {
	
	public LogicaFacade() {
	}

	public String valida(String user, String pwd, Usuari usr) {
		Connection conn = null;
		String error = "";
		try {
			conn = new Connexio().connecta();
			String sql = "select rol from usuari where nomUsuari=? and contrasenya=?";
			PreparedStatement ordre = conn.prepareStatement(sql);
            ordre.setString(1, user);
            ordre.setString(2, pwd);
			ResultSet rs = ordre.executeQuery();
			if(rs.next()) {
				usr.setRol(rs.getString("rol"));
			}else {error="Credencials no vàlides";}
			rs.close();
			ordre.close();
			conn.close();
		} catch(Exception e) {e.printStackTrace();}
		// Seguro per tancar la connexió
		if (conn!=null){
			try {
				conn.close();
			} catch (Exception e){}
		}
		return error;
	}

	public List<String> getPlayers() throws SQLException {
		
		List<String> players = new ArrayList<String>();
		
		Connection connection = new Connexio().connecta();
		String sql = "select nom,nickname,equip from player";
		Statement ordre = connection.createStatement();
		ResultSet rs = ordre.executeQuery(sql);
		
		while(rs.next()) {
			players.add(rs.getString(1)+";"+rs.getString(2)
			+";"+rs.getString(3));
		}
		rs.close();
		ordre.close();
		connection.close();
		return players;

	}
	
	public List<String> getTeams() throws SQLException {
		
		List<String> teams = new ArrayList<String>();
		
		Connection connection = new Connexio().connecta();
		String sql = "select nom from team";
		Statement ordre = connection.createStatement();
		ResultSet rs = ordre.executeQuery(sql);
		
		while(rs.next()) {
			teams.add(rs.getString(1));
		}
		rs.close();
		ordre.close();
		connection.close();
		return teams;

	}
	
	public String getTeamFromPlayer(String nickname) throws SQLException {
		
		String team = "";
		
		Connection connection = new Connexio().connecta();
		String sql = "select equip from player where nickname='"+nickname+"'";
		Statement ordre = connection.createStatement();
		ResultSet rs = ordre.executeQuery(sql);
		
		while(rs.next()) {
			team = rs.getString(1);
		}
		rs.close();
		ordre.close();
		connection.close();
		
		return team;

	}
	
	public void insertPlayer(String nom, String nickname) throws SQLException {
		 String sql = "insert into player(nom,nickname) values(?,?)";
	     Connection connection = new Connexio().connecta();
	     	try {
	            PreparedStatement ordre = connection.prepareStatement(sql);
	            ordre.setString(1, nom);
	            ordre.setString(2, nickname);

	            ordre.executeUpdate();
	            ordre.close();
	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        }
	     	connection.close();
	}
	
	public int insertTeam(String nom) throws SQLException {
		 String sql = "insert into team(nom) values(?)";
		 int codiSortida = 200;
		 
	     Connection connection = new Connexio().connecta();
	     	try {
	            PreparedStatement ordre = connection.prepareStatement(sql);
	            ordre.setString(1, nom);
	            ordre.executeUpdate();
	            ordre.close();
	            
	        } catch (SQLException throwables) {
	            //throwables.printStackTrace();
	            codiSortida = 400;
	        }
	     	
	     connection.close();
	     return codiSortida;	
	}

	public void actualitzarEquipJugador(String equip, String jugador) throws SQLException {
		String sql = "update player set equip=? where nickname=?"; 
	     Connection connection = new Connexio().connecta();
	     	try {
	            PreparedStatement ordre = connection.prepareStatement(sql);
	            ordre.setString(1, equip);
	            ordre.setString(2, jugador);

	            ordre.executeUpdate();
	            ordre.close();
	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        }
	     	connection.close();
	}

	public void eliminarEquip(String equip) throws SQLException {
		Connection connection = new Connexio().connecta();
		String sql = "delete from team where nom='"+equip+"'";
		Statement ordre = connection.createStatement();
		ordre.executeUpdate(sql);
		ordre.close();
		connection.close();
	}
	
	public List<Jugador> getJugadors() throws SQLException {

		List<Jugador> jugadors = new ArrayList<>();
		Connection connection = new Connexio().connecta();
		String sql = "select nom,nickname,equip from player";
		Statement ordre = connection.createStatement();
		ResultSet rs = ordre.executeQuery(sql);
		
		while(rs.next()) {
			jugadors.add(new Jugador(
					rs.getString("nom"),
					rs.getString("nickname"),
					rs.getString("equip")
					));
		}
		rs.close();
		ordre.close();
		connection.close();
		
		return jugadors;

	}
	
	public void generarPDF(String nom, String cognoms, String lloc, String data) throws IOException, ParseException {
		File fitxer = new File("C:\\Users\\Arnau\\eclipse-workspace\\UHC\\src\\main\\webapp\\documents\\prova.xlsx");
		 
        // Create a FileInputStream object
        // for getting the information of the file
        FileInputStream fip = new FileInputStream(fitxer);
		XSSFWorkbook workbook = new XSSFWorkbook(fip);
		XSSFSheet spreadsheet = workbook.getSheet("Comanda");
		XSSFRow row;
		
		XSSFCellStyle capcalera = workbook.createCellStyle();
		capcalera.setFillForegroundColor(new XSSFColor(java.awt.Color.LIGHT_GRAY, new DefaultIndexedColorMap()));
		capcalera.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		capcalera.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM,
				  new XSSFColor(java.awt.Color.BLACK, new DefaultIndexedColorMap()));
		capcalera.setBorderColor(XSSFCellBorder.BorderSide.TOP,
				  new XSSFColor(java.awt.Color.BLACK, new DefaultIndexedColorMap()));
		capcalera.setBorderColor(XSSFCellBorder.BorderSide.LEFT,
				  new XSSFColor(java.awt.Color.BLACK, new DefaultIndexedColorMap()));
		capcalera.setBorderColor(XSSFCellBorder.BorderSide.RIGHT,
				  new XSSFColor(java.awt.Color.BLACK, new DefaultIndexedColorMap()));

    

    // writing the data into the sheets...

//    for (String key : keyid) {
//
//        row = spreadsheet.createRow(rowid++);
//        Object[] objectArr = studentData.get(key);
//        int cellid = 0;
//
//        for (Object obj : objectArr) {
//            Cell cell = row.createCell(cellid++);
//            cell.setCellValue((String)obj);
//            cell.setCellStyle(greenCellStyle);
//        }
//    }
    
    

    int cellid = 0;
    
//    String[] capcalera = {
//    		"Num",
//    		"Actiu",
//    		"Producte",
//    		"Tipus",
//    		"Descripció",
//    		"Preu",
//    		"Mesura",
//    		"Quantitat",
//    		"Comentaris del consumidor",
//    		"Total",
//    		"Quant. en unitats"
//    };
//
//    row = spreadsheet.createRow(rowid++);
//    for (String s : capcalera) {
//    	Cell cell = row.createCell(cellid++);
//        cell.setCellValue(s);
//        cell.setCellStyle(greenCellStyle);
//    }
    
    String[] contingut = {
    		"1",
    		"Des",
    		"Alberginia",
    		"Blanca",
    		"",
    		"2,8",
    		"",
    		"",
    		"",
    		"0,00 €",
    		""
    };
    
    row = spreadsheet.createRow(10);
    for (String s : contingut) {
    	Cell cell = row.createCell(cellid++);
        cell.setCellValue(s);
        cell.setCellStyle(capcalera);
        spreadsheet.autoSizeColumn(cellid);
    }
    SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");  
    Date date = parser.parse(data);
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    
    spreadsheet.getRow(2).getCell(2).setCellValue(nom);
    spreadsheet.getRow(2).getCell(5).setCellValue(cognoms);
    spreadsheet.getRow(3).getCell(2).setCellValue(lloc);
    spreadsheet.getRow(3).getCell(5).setCellValue(formatter.format(date));
    
    System.out.println("Nº total columnes: "+spreadsheet.getPhysicalNumberOfRows());
    for(int i=0;i<spreadsheet.getPhysicalNumberOfRows();i++) {
    	spreadsheet.autoSizeColumn(i);
    }

    // .xlsx is the format for Excel Sheets...
    // writing the workbook into the file...
    FileOutputStream out;
	try {
		out = new FileOutputStream(
		    new File("C:\\Users\\Arnau\\eclipse-workspace\\UHC\\src\\main\\webapp\\documents\\prova.xlsx"));
		workbook.write(out);
		out.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
		Workbook wb = new Workbook();
        wb.loadFromFile("C:\\Users\\Arnau\\eclipse-workspace\\UHC\\src\\main\\webapp\\documents\\prova.xlsx");
 
        //Fit to page
        wb.getConverterSetting().setSheetFitToPage(true);
 
        //Save to PDF file
        wb.saveToFile("C:\\Users\\Arnau\\eclipse-workspace\\UHC\\src\\main\\webapp\\documents\\comanda.pdf",FileFormat.PDF);
        
        workbook.close();

	}

	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	*/
	
	
	public void generarInforme() throws SQLException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("Informe");
		//spreadsheet.getPrintSetup().setScale((short) 200);
		workbook.setPrintArea(0, 0, 6, 0, 49);
		
		XSSFRow row;
		Cell cell;
		
		XSSFCellStyle capcalera = workbook.createCellStyle();
		capcalera.setFillForegroundColor(new XSSFColor(java.awt.Color.LIGHT_GRAY, new DefaultIndexedColorMap()));
		capcalera.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		capcalera.setBorderColor(XSSFCellBorder.BorderSide.BOTTOM,
				  new XSSFColor(java.awt.Color.BLACK, new DefaultIndexedColorMap()));
		capcalera.setBorderColor(XSSFCellBorder.BorderSide.TOP,
				  new XSSFColor(java.awt.Color.BLACK, new DefaultIndexedColorMap()));
		capcalera.setBorderColor(XSSFCellBorder.BorderSide.LEFT,
				  new XSSFColor(java.awt.Color.BLACK, new DefaultIndexedColorMap()));
		capcalera.setBorderColor(XSSFCellBorder.BorderSide.RIGHT,
				  new XSSFColor(java.awt.Color.BLACK, new DefaultIndexedColorMap()));
    
		row = spreadsheet.createRow(0);
		
        cell = row.createCell(0);
        cell.setCellValue("Nom");
        cell.setCellStyle(capcalera);
        cell = row.createCell(1);
        cell.setCellValue("Nickname");
        cell.setCellStyle(capcalera);
        cell = row.createCell(2);
        cell.setCellValue("Equip");
        cell.setCellStyle(capcalera);
		
    int rowCompt = 1;
    for(Jugador j : getJugadors()) {
    	row = spreadsheet.createRow(rowCompt);
        cell = row.createCell(0);
        cell.setCellValue(j.getNom());
        cell = row.createCell(1);
        cell.setCellValue(j.getNickname());
        cell = row.createCell(2);
        cell.setCellValue(j.getEquip());

//        /* Read the input image into InputStream */
//        InputStream my_banner_image = new FileInputStream("C:\\Users\\Arnau\\eclipse-workspace\\UHC\\src\\main\\webapp\\img\\player.png");
//        /* Convert Image to byte array */
//        byte[] bytes = IOUtils.toByteArray(my_banner_image);
//        /* Add Picture to workbook and get a index for the picture */
//        int my_picture_id = workbook.addPicture(bytes, org.apache.poi.ss.usermodel.Workbook.PICTURE_TYPE_JPEG);
//        /* Close Input Stream */
//        my_banner_image.close();
//      //Returns an object that handles instantiating concrete classes
//        CreationHelper helper = workbook.getCreationHelper();
//        //Creates the top-level drawing patriarch.
//        Drawing drawing = spreadsheet.createDrawingPatriarch();
//
//        //Create an anchor that is attached to the worksheet
//        ClientAnchor anchor = helper.createClientAnchor();
//
//        //create an anchor with upper left cell _and_ bottom right cell
//        anchor.setCol1(3); //Column B D
//        anchor.setRow1(1); //Row 3
//        anchor.setCol2(4); //Column C E
//        anchor.setRow2(4); //Row 4
//
//        //Creates a picture
//        Picture pict = drawing.createPicture(anchor, my_picture_id);
//
//        cell = spreadsheet.createRow(10).createCell(1);
       
        
        //cell.setCellStyle(greenCellStyle);
        spreadsheet.autoSizeColumn(rowCompt-1);
    	rowCompt++;
    }
    System.out.println("Nº total columnes: "+spreadsheet.getPhysicalNumberOfRows());
    for(int i=0;i<spreadsheet.getPhysicalNumberOfRows();i++) {
    	spreadsheet.autoSizeColumn(i);
    }

    // .xlsx is the format for Excel Sheets...
    // writing the workbook into the file...
    //fip.close();
    FileOutputStream out;
	try {
		out = new FileOutputStream(
		    new File("C:\\Users\\Arnau\\eclipse-workspace\\UHC\\src\\main\\webapp\\documents\\informe.xlsx"));
		workbook.write(out);
		out.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
		Workbook wb = new Workbook();
        wb.loadFromFile("C:\\Users\\Arnau\\eclipse-workspace\\UHC\\src\\main\\webapp\\documents\\informe.xlsx");
 
        //Fit to page
        wb.getConverterSetting().setSheetFitToPage(true);
 
        //Save to PDF file
        wb.saveToFile("C:\\Users\\Arnau\\eclipse-workspace\\UHC\\src\\main\\webapp\\documents\\informe.pdf",FileFormat.PDF);
        
        workbook.close();
        
        
        //fitxer.delete();
		
	}

	
}
