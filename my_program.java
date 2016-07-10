import java.io.*;
class Car{
	String reg_no,colour;boolean free;
	public Car(String r,String c){
		reg_no=r;
		colour=c;
	}
	public Car(){
		reg_no="";
		colour="";
		free=false;
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
		Car cars[]=new Car[noOfSlots];
		for(int j=0;j<noOfSlots;j++)
			cars[j]=new Car();
		while(!input.equals(" ")){
			input=ab.readLine();input+=' ';
			String input1="",input2="",input3="",temp="";int i,flag=0;
			for(i=0;i<input.length();i++){
				char c=input.charAt(i);
				if(c==' '){
					if(flag==0){
						input1=temp;
						temp="";
						flag=1;
					}
					else if(flag==1){
						input2=temp;
						temp="";
						flag=2;
					}
					else{
						input3=temp;
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
			//	System.out.println("ff "+input1+input2+input3+commandPosition);
			switch(commandPosition){
				case 1:
					if(noOfCars==noOfSlots){
						System.out.println("Sorry, parking lot is full");
					}
					else{

						for(i=0;i<noOfSlots;i++){
							if(!cars[i].free){
								cars[i].reg_no=input2;
								cars[i].colour=input3;
								cars[i].free=true;
								noOfCars++;
								System.out.println("Allocated slot number: "+i);
								break;
							}
						}
					}
					break;
				default: 
					if(!input.equals(" "))
							System.out.println("Wrong command");

							}


							}




							}
							}
