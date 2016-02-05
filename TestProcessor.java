package Calc;

import javafx.scene.control.TextField;

public class TestProcessor extends AbstractProcessor{
//	 private int val1;
//	 private int val2;
//	 private int tempVal;
	 private int count = 0;
	 private int countPlus = 0;
	 private int countMinus = 0;
	 private int countDelenie = 0;
	 private int countUmnog = 0;
	 private char operation;
	 
	 private int res=0;
	 private char [] chars = {'1','2','3','4','5','6','7','8','9','0'};
	 private char [] charsAr = {'/','*', '+', '-', '='};

	 
	 @Override
	 public void inputChar(char c) {
//	  System.out.println("Введено "+c);
	for (int i =0; i< chars.length; i++) {
		if (chars[i] == c) {
			  if (count == 0) {
				  res = c - '0';
				  count++;
			  } else if (count!=0) {
				  res = res*10 + (c - '0');
//				  count++;
			  }
		}	setResult(res);
			
	}

	
	  
	// Операция суммирования
	  if (c == '+' && countPlus == 0 && count != 0) {
		  setTemp(res);
		  count = 0;
		  countPlus =1;
		  operation = '+';
	  } else if (c == '+' && countPlus != 0  && count ==1) {
		  res = getTemp() + res;
		  setTemp(res);
		  setResult(res);	
		  operation = '+';
		  count = 0;
	  } else if (c == '+' && countPlus != 0 && count !=0) {
		  res = getTemp() + res;
		  setResult(res);
		  operation = '+';
	  }
	  
	  //Операция отнимания
	  if (c == '-' && countMinus == 0 && count != 0) {
		  setTemp(res);
		  count = 0;
		  countMinus =1;
		  operation = '-';
	  } else if (c == '-' && countMinus != 0  && count ==1) {
		  res = getTemp() - res;
		  setTemp(res);
		  setResult(res);	
		  operation = '-';
		  count = 0;
	  } else if (c == '-' && countMinus != 0 && count !=0) {
		  res = getTemp() - res;
		  setResult(res);
		  operation = '-';
	  } 
	  
	  //Знак равно '='
	  if (c == '=' && getTemp() != 0) {
		  if (operation == '+') {
		  res = getTemp() + res;
		  setResult(res);
		  } else if (operation == '-') {
			  res = getTemp() - res;
			  setResult(res);
		  } else if (operation == '*') {
			  res = getTemp() * res;
			  setResult(res);
		  } else if (operation == '/') {
			  res = getTemp() / res;
			  setResult(res);
		  }
	  } 
	  
	  //Операция умножения
	  if (c == '*' && countUmnog == 0 && count != 0) {
		  setTemp(res);
		  count = 0;
		  countUmnog =1;
		  operation = '*';
	  } else if (c == '*' && countUmnog != 0  && count ==1) {
		  res = getTemp() * res;
		  setTemp(res);
		  setResult(res);	
		  operation = '*';
		  count = 0;
	  } else if (c == '*' && countUmnog != 0 && count !=0) {
		  res = getTemp() * res;
		  setResult(res);
		  operation = '*';
	  } 
	  
	  //Операция деления
	  if (c == '/' && countDelenie == 0 && count != 0) {
		  setTemp(res);
		  count = 0;
		  countDelenie =1;
		  operation = '/';
	  } else if (c == '/' && countDelenie != 0  && count ==1) {
		  res = getTemp() / res;
		  setTemp(res);
		  setResult(res);
		  operation = '/';
		  count = 0;
	  } else if (c == '/' && countDelenie != 0 && count !=0) {
		  res = getTemp() / res;
		  setResult(res);
		  operation = '/';
	  } 
	  
	  //Операция сброса
	  
	  if (c == 'c') {
		  setTemp(0);
		  setResult(0);
		  count = 0;
		  countPlus = 0;
		  countMinus = 0;
		  countDelenie = 0;
		  countUmnog = 0;
	  }
	  
	  
	  
	
	  //==================== Старое и не работает !!!===================
	  
//	  str = res.toString();
//	  setTextRs(str);
//	  textRes.setText(str);
//	  setText(textRes);
//	  
	  
	  
	  
//	  if (c!= '+')setResult(c-(int)('0')/*getResult()+1*/); 
//	  String str = "";
//	  if (c != '+' && c != '='){
//	  str = str + c;
//	  }
//	  if (c == '+') {
//		  //String s = str.substring(0, str.length());
//		  Integer in = new Integer (str);
//		  int a = in.parseInt(str);
//		  setTemp(a);
//		  res = res + getTemp();
//		  setResult(res);
//	  }
	  
 	  
	  
	  //Обработка цифр
	  	
//		  int temp = getTempVal();
//		  Integer t = new Integer(temp);
//		  String s = t.toString();
//		  s = s + c;
//		  Integer t1 = new Integer(s);
//		  int temp1 = t1.parseInt(s);
//		  //setTemp(temp1);
//		  setTempVal(temp1);
		

		 
//		 //арифметика
//		 if (c == '+') {
//			 setVal1(getTempVal());
//			if (count == 0) {
//				res = res + getVal1();
//				setTempVal(0);
//				setResult(res);
//				count ++;
//			}
//			
//				 res = getResult() + getVal1();
//				 setTemp(getVal1());
//				 setResult(res);
//				 setTempVal(0);
//		 }
//		 if (c == '=') {
//			 int a = 0;
//			 if (getVal1() != 0 && a == 0) {
//				 setVal2(getTempVal());
//				 res = getVal1() + getVal2();
//				 setResult(res);
//				 setTemp(res);
//				 setTempVal(0);
//				 a++;
//			 }
//			 if (getVal1() != 0 && a != 0) {
//				 res = getTempVal() + getResult();
//			 }
//			
//		 }		   
	 }
//	public int getVal1() {
//		return val1;
//	}
//	public void setVal1(int val1) {
//		this.val1 = val1;
//	}
//	public int getVal2() {
//		return val2;
//	}
//	public void setVal2(int val2) {
//		this.val2 = val2;
//	}
//	public int getTempVal() {
//		return tempVal;
//	}
//	public void setTempVal(int tempVal) {
//		this.tempVal = tempVal;
//	}
	
	}