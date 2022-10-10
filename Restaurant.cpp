#include<iostream>
#include<conio.h>

#define B 200;
#define F 50;
#define P 500;
#define S 150;

using namespace std;

void displaymenu();
void takecustomerdata();

int main()
{
displaymenu();

takecustomerdata();

getch();
return 0;
}

void displaymenu()
{
cout<<“Menu”<<endl;
cout<<“B-Burger”<<endl;
cout<<“F-French Fries”<<endl;
cout<<“P-Pizza”<<endl;
cout<<“S-Sandwich”<<endl;
}

void takecustomerdata()
{

int quantity;
char type;
double charge;

cout<<“Enter Food Type and Quantity ? Food Type [B or F or P or S]”<<endl;
cin>>type>>quantity;

cout<<“You ordered “<<quantity<<” “<<type<<endl;

switch(type)
{
case ‘B’:
charge = quantity * 200;
cout<<“Total Charge: “<<charge<<endl;
break;

case ‘F’:
charge = quantity * 50;
cout<<“Total Charge: “<<charge<<endl;
break;
case ‘P’:
charge = quantity * 500;
cout<<“Total Charge: “<<charge<<endl;
break;
case ‘S’:
charge = quantity * 500;
cout<<“Total Charge: “<<charge<<endl;
break;
default:
cout<<“You entered invalid type!”;
}
}

 

Program Code for Question 2.

/* Program to make a simple calculator to Add, Subtract, Multiply and Divide using functions*/
#include<iostream>
#include<conio.h>
using namespace std;

void simplecalculator();

int main()
{
simplecalculator();
}

void simplecalculator()
{
char c;
int a,b,add,sub,mul,div;
cout<<“Enter Operation [+,-,*,/] \n”;
cin>>c;

cout<<“Enter any two numbers”<<endl;
cin>>a>>b;

switch(c)
{
case ‘+’:
add = a + b;
cout<<“Addition of two number is “<<add<<endl;
break;

case ‘-‘:
sub = a – b;
cout<<“Subtraction of two number is “<<sub<<endl;
break;

case ‘*’:
mul = a * b;
cout<<“Multiplication of two number is “<<mul<<endl;
break;

case ‘/’:
div = a / b;
cout<<“Division of two number is “<<div<<endl;
break;

default:
cout<<“Invalid Input”<<endl;

}
}
