package br.com.brotolegal.savdatabase.entities;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.brotolegal.savdatabase.dao.FileTable;
import br.com.brotolegal.savdatabase.dao.HelpFiltro;
import br.com.brotolegal.savdatabase.dao.HelpParam;
import br.com.brotolegal.savdatabase.database.ObjRegister;


public class Marca extends ObjRegister {
	
	protected String CODIGO;
	protected String DESCRICAO;
	
	protected static final String _OBJETO = "br.com.brotolegal.savdatabase.entities.Marca";
	
	public Marca(){
		
		 super(_OBJETO,"MARCA");
		 
		 loadColunas();

		 InicializaFields();
	}
	



	public Marca(String cODIGO, String dESCRICAO) {

		super(_OBJETO,"MARCA");

		loadColunas();

		InicializaFields();

		CODIGO = cODIGO;
		DESCRICAO = dESCRICAO;
		

		
	}



	public String getCODIGO() {
		return CODIGO;
	}







	public void setCODIGO(String cODIGO) {
		CODIGO = cODIGO;
	}







	public String getDESCRICAO() {
		return DESCRICAO;
	}







	public void setDESCRICAO(String dESCRICAO) {
		DESCRICAO = dESCRICAO;
	}




	@Override
	public void loadHelp() {
		
		List<HelpParam> help = new ArrayList<HelpParam>();
		help.add(new HelpParam("DESCRI��O" ,
				  "SELECT CODIGO,DESCRICAO FROM MARCA  ", 
				  "WHERE DESCRICAO LIKE ''%{0}%'' "           ,
				  "ORDER BY DESCRICAO",
				  "DESCRICAO",
				  new String[] {"CODIGO"},
				  "",
				  new String[] {}));
		help.add(new HelpParam("CODIGO",
				"SELECT CODIGO,DESCRICAO FROM MARCA  ", 
				"WHERE CODIGO LIKE ''{0}%'' "           , 
				"ORDER BY CODIGO,DESCRICAO",
				"CODIGO",
				 new String[] {"CODIGO"},
				 "",
				 new String[] {}));
				 
		
		List<HelpFiltro> filtro    = new ArrayList<HelpFiltro>();
		
		_fileTable.add(new FileTable("MARCA", help, filtro, null));
		
		loadTableHelp("MARCA");

	};
	
	@Override
	public String[] getHelpLinhas(Cursor cursor) {
		
		String[] retorno = {"", //linha1
				"", //linha2
				"", //letra
				"", //texto1
		""}; //texto2


		String linha1    = "";
		String linha2    = "";
		String letra     = "";
		String texto1    = "";
		String texto2    = "";

		try
		{

			linha1 = "Código: "+cursor.getString(cursor.getColumnIndex("codigo"))+" Grupo: "+cursor.getString(cursor.getColumnIndex("descricao"));

			linha2 = "";
			
			letra  = cursor.getString(cursor.getColumnIndex("descricao")).substring(0, 1);

		}catch(Exception e) {

			linha1 = e.getMessage();

		}


		retorno[0] = linha1;
		
		retorno[1] = linha2;
		
		retorno[2] = letra;
		
		retorno[3] = texto1;
		
		retorno[4] = texto2;
		
		return retorno;

		
	};



	





	@Override
	public void loadColunas() {
		
		_colunas = new ArrayList<String>();
		_colunas.add("CODIGO");
		_colunas.add("DESCRICAO");
	
	}


}
