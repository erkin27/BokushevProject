package Calc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Calculator extends Application {
	private AbstractProcessor proc;
	private Calc calc;
	private TextField textResult;
	private char [] chars = {'1','2','3','4','5','6','7','8','9','0'};
	 
	public static void main(String[] args) {
		launch (args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Калькулятор");
		stage.setScene(MyScene());
		stage.show();
	}
	public Scene MyScene() {
		 proc = new TestProcessor();
		 calc = new Calc(proc);
		// Основной грид
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		//Расстояние между гридами по вертикали и по горизонтали
//		  gp.setHgap(20);
		  gp.setVgap(10);
		//Гриды для вывода результата и кнопок
		GridPane result = new GridPane();
		GridPane buttons = new GridPane(); buttons.setAlignment(Pos.CENTER);
		gp.add(result, 0, 0);
		gp.add(buttons, 0, 1);
		//Добавляем поле для вывода результата 
		textResult = new TextField();
		textResult.setMinWidth(240);
		textResult.setMinHeight(40);
		result.add(textResult,0,0);
		//Grid Buttons
		 HBox hb1 = new HBox(0); //0 - расстояние между кнопками на панели
		 HBox hb2 = new HBox(0);
		 HBox hb3 = new HBox(0);
		 HBox hb4 = new HBox(0);
		 buttons.add(hb1, 0, 0);
		 buttons.add(hb2, 0, 1);
		 buttons.add(hb3, 0, 2);
		 buttons.add(hb4, 0, 3);
		//=============================================================
		 class MyEvent<T> implements EventHandler{
			   char name;
			   @Override
			   public void handle(Event arg0) {
			    calc.inSymv(name); 
			    String s = Integer.toString(proc.getResult());
			    textResult.setText(s);
			   }
			   public MyEvent(char n){
			    this.name = n;
			   }
			  }
		 //================================================================
		 
		//Добавляем кнопки
		Button [] btns = new Button [chars.length];
		for (int i = 0; i<btns.length; i++) {
			btns[i] = new Button("" + chars[i]);
			btns[i].setMinWidth(60);
			btns[i].setMinHeight(60);
			btns[i].setStyle("-fx-color:#7F7D7A");
			btns[i].setOnAction(new MyEvent(chars[i]));
		}
		int x = 0, y = 0;
		for (int i =0; i<btns.length; i++) {
			if (y == 0) {
				hb1.getChildren().add(btns[i]);
				x++;
				if (x == 3) {
					y=1; x = 0;
				}
			} else if (y == 1) {
				hb2.getChildren().add(btns[i]);
				x++;
				if (x == 3){
					y=2; x = 0;
				}
			} else if (y == 2) {
				hb3.getChildren().add(btns[i]);
				x++;
				if (x == 3){
					y=3; x = 0;
				}
			}else if (y == 3) {
				hb4.getChildren().add(btns[i]);
			}
		}
	
		Button buttonPoint = new Button("C");
		buttonPoint.setMinWidth(60);
		buttonPoint.setMinHeight(60);
		buttonPoint.setStyle("-fx-color:#7F7D7A");
		hb4.getChildren().add(buttonPoint);
		buttonPoint.setOnAction(new MyEvent('c'));
		
		//Кнопка "0"
		btns[btns.length-1].setMinWidth(60);
		btns[btns.length-1].setMinHeight(60);
		btns[btns.length-1].setOnAction(new MyEvent('0'));
		//Кнопка "="
		Button buttonRavno = new Button("=");
		buttonRavno.setMinWidth(60);
		buttonRavno.setMinHeight(60);
		buttonRavno.setOnAction(new MyEvent('='));
		buttonRavno.setStyle("-fx-color:#675948");
		hb4.getChildren().add(buttonRavno);
		//Арифметические кнопки через массив
		Button [] btnsArihmetic = new Button[4];
		for (int i =0; i< btnsArihmetic.length; i++) {
			if(i==0) {
				btnsArihmetic[i] = new Button("/"); 
				btnsArihmetic[i].setOnAction(new MyEvent('/'));
				hb1.getChildren().add(btnsArihmetic[i]);
			} else if (i ==1) {
				btnsArihmetic[i] = new Button("*"); 
				btnsArihmetic[i].setOnAction(new MyEvent('*'));
				hb2.getChildren().add(btnsArihmetic[i]);
			} else if (i ==2) {
				btnsArihmetic[i] = new Button("-"); 
				btnsArihmetic[i].setOnAction(new MyEvent('-'));
				hb3.getChildren().add(btnsArihmetic[i]);
			} else if (i ==3) {
				btnsArihmetic[i] = new Button("+");
				btnsArihmetic[i].setOnAction(new MyEvent('+'));
				hb4.getChildren().add(btnsArihmetic[i]);
			}
		}
		//Форматирование стиля и размера арифметических кнопок
		for (int i =0; i< btnsArihmetic.length; i++){
			btnsArihmetic[i].setMinWidth(60);
			btnsArihmetic[i].setMinHeight(60);
			btnsArihmetic[i].setStyle("-fx-color:#675948");
		}
			
		
		//Добавляем все в сцену
		Scene scene = new Scene(gp, 250, 300);
		return scene;
	}
	
	//сеттеры и геттеры
	public AbstractProcessor getProc() {
		return proc;
	}
	public void setProc(AbstractProcessor proc) {
		this.proc = proc;
	}
	
	public char [] getChars() {
		return chars;
	}
	public void setChars(char [] chars) {
		this.chars = chars;
	}
}
