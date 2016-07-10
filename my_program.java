import java.io.*;
class Car{
	String reg_no,colour;
	public Car(String r,String c){
		reg_no=r;
		colour=c;
	}
}

class Main{

	public static void main(String args[])throws IOException{
		BufferedReader ab=new BufferedReader(new InputStreamReader(System.in));
		String commands[]={"create_parking_lot","park","leave","status","registration_numbers_of_cars_with_colour","slot_numbers_for_cars_with_colour","slot_number_for_registration_number"};
		int noOfSlots=0,noOfCars=0;String input="",command="";
		while(!command.equals(commands[0])){
			input=ab.readLine();input+=' ';
			int i,flag=0;String temp="";
			for(i=0;i<input.length();i++){
				char c=input.charAt(i);
				if(c==' '){
					if(flag==0){
						command=temp;
						temp="";
						flag=1;
					}
					else{
						noOfSlots=Integer.parseInt(temp);
						break;
					}
				}
				else
					temp=temp+c;
			}
			if(!command.equals(commands[0]))
				System.out.println("Wrong command. Create parking lot first");
		}
		System.out.println("Created a parking lot with "+noOfSlots+" slots");

		while(!input.equals(" ")){
			input=ab.readLine();input+=' ';
			String input1="",input2="",temp="";int i,flag=0;
			for(i=0;i<input.length();i++){
				char c=input.charAt(i);
				if(c==' '){
					if(flag==0){
						input1=temp;
						temp="";
						flag=1;
					}
					else{
						input2=temp;
						break;
					}
				}
				else
					temp=temp+c;
			}
			int commandPosition=0;
			for(i=0;i<7;i++){

				if(input1.equals(commands[i])){
					commandPosition=i;
					break;
				}
			}




		}




	}
}
