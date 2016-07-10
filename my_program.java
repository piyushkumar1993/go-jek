import java.io.*;
class Car{
	String reg_no,colour;boolean filled;
	public Car(String r,String c){
		reg_no=r;
		colour=c;
	}
	public Car(){
		reg_no="";
		colour="";
		filled=false;
	}
}

class my_program{

	public static void main(String args[])throws IOException{
		BufferedReader ab=null;
		
		PrintStream out=null;
//System.out.println("ggg"+args.length);
if(args.length==0){
out=new PrintStream(System.out);
ab=new BufferedReader(new InputStreamReader(System.in));
}
else{
FileInputStream fin=new FileInputStream(args[0]);
ab=new BufferedReader(new InputStreamReader(fin));
FileOutputStream fout=new FileOutputStream(args[2],false);
out=new PrintStream(fout);

}



String commands[]={"create_parking_lot","park","leave","status","registration_numbers_for_cars_with_colour","slot_numbers_for_cars_with_colour","slot_number_for_registration_number"};
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
				out.println("Wrong command. Create parking lot first");
		}
		out.println("Created a parking lot with "+noOfSlots+" slots");
		Car cars[]=new Car[noOfSlots];
		for(int j=0;j<noOfSlots;j++)
			cars[j]=new Car();
		while((input=ab.readLine())!=null){
			input+=' ';
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
						out.println("Sorry, parking lot is full");
					}
					else{

						for(i=0;i<noOfSlots;i++){
							if(!cars[i].filled){
								cars[i].reg_no=input2;
								cars[i].colour=input3;
								cars[i].filled=true;
								noOfCars++;
								out.println("Allocated slot number: "+(i+1));
								break;
							}
						}
					}
					break;

				case 2:
					int carToLeave=Integer.parseInt(input2);
					carToLeave--;
					if(carToLeave<noOfSlots){
						out.println("Slot number "+(carToLeave+1)+" is free");
						if(cars[carToLeave].filled){
							cars[carToLeave].filled=false;
							noOfCars--;
						}
					}
					break;			
				case 3:
					out.println("Slot No.\tRegistration No\tColour");
					for(i=0;i<noOfSlots;i++){
						if(!cars[i].filled)
							continue;
						out.println((i+1)+"\t"+cars[i].reg_no+"\t"+cars[i].colour);
					}
					break;

				case 4: 
					int flag2=0;
					for(i=0;i<noOfSlots;i++){
						if(cars[i].colour.equalsIgnoreCase(input2)&&cars[i].filled){
							if(flag2==0){
								out.print(cars[i].reg_no);
								flag2=1;
							}
							else
								out.print(", "+cars[i].reg_no);
						}
					}
					out.println("");
					break;
				case 5:
					flag2=0;
					for(i=0;i<noOfSlots;i++){
						if(cars[i].colour.equalsIgnoreCase(input2)&&cars[i].filled){
							if(flag2==0){
								out.print((i+1));
								flag2=1;
							}
							else
								out.print(", "+(i+1));
						}
					}
					out.println("");
					break;

				case 6:
					flag2=0;
					for(i=0;i<noOfSlots;i++){
						if(cars[i].filled && cars[i].reg_no.equals(input2)){
							out.println((i+1));flag2=1;break;
						}
					}
					if(flag2==0)
						out.println("Not found");
					break;
				default: 
					if(!input.equals(" "))
						out.println("Wrong command");

			}


		}




	}
}
