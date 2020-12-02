package project_1p;
import java.util.*;
import java.io.*;

abstract class timed//abstract class containing all functions related to time calculation
{
abstract protected void start_d();	
abstract protected void end_d();	
abstract protected int diff_d();
}

interface total//interface 
{
	void display();
	void remingredients();
	void ingredients();
	void days_of_selected();
}

class basics//class containing basic function
{
	protected void wait(int ms)//for using pause
	{
	try
	{
	Thread.sleep(ms);
	}
	catch(InterruptedException ex)
	{
	Thread.currentThread().interrupt();
	}
	}	
}

class items_class extends basics implements total//class having all major functions
{
private String ing[]={"Butter","Milk","Egg","Tomato","Cucumber","Mushroom","Chili","Corn","Ginger","Chicken","Chevon","Pork","Tuna","Salmon","Crab","Prawn","Soup","Cola","Cheese","Bread"};
private int which[]=new int[20];
private int da[]=new int[20];
private int ex[]= {30,3,25,10,6,10,12,5,20,3,3,3,4,2,2,3,7,4,7,4};
private int arr[]={0,0,0};
private String s="";
private int noit=0;
Scanner z =new Scanner(System.in);

protected int noofin()//number of current ingredients
{
	return noit;
}

public void display()//display the list of available
{
int i=0;
for(i=0;i<20;i++)
{
if(ing[i].length()<=7)
System.out.print(ing[i]+"				");	
else
System.out.print(ing[i]+"			");
if(i%2!=0)
System.out.println();
}
}

protected void filh(String fut)//items not in list 
{
	System.out.println("The item you entered is not in the list\nIf you want to add the item in list in future updates of software");	
	System.out.println("Press \"Yes\"/\"Y\"/\"1\" to add in future updates\nPress \"No\"/\"N\"/\"0\" otherwise ");
	String s1=z.next();
	if(s1.equalsIgnoreCase("Yes") || s1.equalsIgnoreCase("Y") ||s1.equals("1"))
	{
		try {
            FileWriter writer = new FileWriter("Future.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(fut);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		System.out.println("Continue with the items to store in the fridge");
	}
	else
		System.out.println("Continue with the items to store in the fridge");
}

public void ingredients()//accepts ingredients by user
{
int i=0,j=0;
System.out.println("Enter Stop\\0 to Poceed Further  :-)");
String s1="";
ac:while(!s1.equals("stop"))
{
s1=z.next();
noit++;
if(s1.equals("stop") || s1.equals("0"))
break ac;
for(i=0;i<20;i++)
{
	if(s1.equalsIgnoreCase(ing[i]))
	{
		which[i]=1;
	j++;
	}
	else 
	if(which[i]!=1)
	which[i]=0;
}
if(j==0)
{
	items_class obj=new items_class();
	obj.filh(s1);
}
j=0;
}
}

public void remingredients()//accepts items out of remaining ingredients
{
int i=0;
System.out.println("Enter Stop\\0 to End :-)");
String s1="";
aab:while(true)
{
s1=z.next();
noit--;
if(s1.equals("stop") || s1.equals("0"))
break aab;
for(i=0;i<20;i++)
{
if(s1.equalsIgnoreCase(ing[i]))
{
if(which[i]==0)
System.out.println("Please Enter item that exists in the Fridge");
else
which[i]=0;
}
}

}
}

protected void remdisplay()//displays items already present
{
int i=0,j=0;
for(i=0;i<20;i++)
{
if(which[i]==1)
{
	j++;
if(ing[i].length()<=7)
System.out.print(ing[i]+"				");	
else
System.out.print(ing[i]+"			");
if(j%2==0)
	System.out.println();
}
}	
System.out.println();
}


protected void remdisplay2()//displays items already present
{
int i=0;
for(i=0;i<20;i++)
{
if(which[i]==1)
{
	if(da[i]>=2)
		System.out.println(ing[i].toUpperCase()+": has "+da[i]+" days: In good condition");	
	if(da[i]<2 && da[i]>=0)
		System.out.println(ing[i].toUpperCase()+": should be consumed fast");
	if(da[i]<0)
		System.out.println(ing[i].toUpperCase()+": check for quality before eating");



}
}	
System.out.println();
}

protected int safeing()//accepts items
{
	System.out.println("Enter the ingredient from the above list to know about: \nTIPS to make it last longer in the fridge");	
	String s1=z.next();
	int i;
	for(i=0;i<20;i++)
	if(s1.equalsIgnoreCase(ing[i]))
		break;
	if(i<20)
		return i;
	else
		return -1;
	
}

protected void safetip(int tip)//contains tips to save items last longer
{
	System.out.println();
switch(tip)
{
case 1:
	System.out.println("Refrigerate the rest in an airtight container to ensure optimum freshness. \nAdding a little water seals out air, keeping butter \nsoft, sweet and spreadable for up to 30 days. You might want to form your butter into blocks before \nyou store it.\r\n"
			+ "");
	break;
case 2:
	System.out.println("Now science has figured out how to make milk last two months. \nThanks, science! Typically, pasteurization is done one of two ways: \nEither using a \"high-temperature, short-time treatment\" of 161°F for 15 seconds, or a \"low-temperature, \nlong-time treatment\" of 145°F for 30 seconds.");
	break;
case 3:
	System.out.println("The simplest solution to preserving eggs is to simply keep them cool. \nEggs have a natural coating on the outside that helps keep the \negg inside from spoiling. If that's washed off, the eggs must be refrigerated. Unwashed eggs, however, \ncan be stored in a cool closet or back room for weeks.");
	break;
case 4:
	System.out.println("Remove any large pieces of stem and then store your tomatoes \nstem-side down on a flat surface, as this will help limit moisture-loss\n and keep them juicier for a few more days. The simplest way to store tomatoes for the longest time is to \nmake puree out of them");
	break;
case 5:
	System.out.println("According to Mendelson, cucumbers keep best in the fridge when they're \nindividually wrapped in paper towels before going into the \nzip-top bag.\r\n"
			+ "1.Wrap each cucumber individually in paper towels.\r\n"
			+ "2.Place them in a zip-top bag and seal tightly.\r\n"
			+ "3.Store up to one week in the fridge.\r\n"
			+ "");
	break;
case 6:
	System.out.println("Place whole, unwashed mushrooms in a brown paper bag and fold the top of \nthe bag over. Then stick the bag in the main compartment of \nyour refrigerator. This works because the bag absorbs excess moisture from the mushrooms so they don't get \nsoggy or moldy.");
	break;
case 7:
	System.out.println("To preserve green chillies for longer period, store them in zip lock bags. \nJust remove the stem part of the chillies and transfer them \ninside a zip lock bag. Place the bag inside a refrigerator and use the green chillies as and when required.\n This way, your chillies can stay fresh for upto a week or so.\r\n"
			+ "");
	break;
case 8:
	System.out.println("Keeping fresh corn from drying out is key. At home, store the ears wrapped \ntightly in a plastic bag in the refrigerator. If you don't \nplan on eating your corn within three days—and you should unless you like mouthfuls of starch—freeze it.");
	break;
case 9:
	System.out.println("Avoid moist and moldy ginger. Always store the ginger in a paper bag or paper \ntowel and then store it in the refrigerator or freezer. \nPack a chunk of ginger by wrapping it properly until there is no place left for it to get exposed to air \nand moisture. This way you will be able to store it for longer.\r\n"
			+ "");
	break;
case 10:
	System.out.println("Store raw chicken  in its original packaging, on the bottom shelf of your fridge. \nJust make sure the packaging is well-sealed and away \nfrom other foods and cooked meats. Double check that your fridge is set to 0-5°C. This keeps your chicken \n– and all the food in your fridge – fresher for longer.");
	break;
case 11:
	System.out.println("Store ground goat meat only 1 or 2 days in the refrigerator before either \ncooking or freezing it. Roasts, steaks and chops can be kept \nrefrigerated 3 to 5 days before cooking. After cooking, keep refrigerated 3 to 4 days. For best quality, \ncooked meat and raw ground meat can be frozen and used within 3 to 4 months.");
	break;
case 12:
	System.out.println("Sealed, pre-packed fresh pork cuts can be kept in the refrigerator 2 to 4 days; \nsealed ground pork will keep in the refrigerator for 1 to 2 \ndays. If you do plan on keeping the raw, fresh pork longer than 2 to 3 days before cooking it, store \nit well-wrapped in the freezer.\r\n"
			+ "");
	break;
case 13:
	System.out.println("Keep the tuna refrigerated until you are ready to use it. It is best to use \nfresh tuna the day of purchase. If you need to store it, pat it \ndry, wrap securely in plastic wrap or foil and store in the coldest part of your refrigerator (optimum \ntemperature of 31 F).\r\n"
			+ "");
	break;
case 14:
	System.out.println("You can help salmon keep fresh longer by storing it in your refrigerator\n immediately after use. Once prepared, salmon should be stored in a \ntightly closed container to keep out moisture and other contaminants and returned to the fridge.\r\n"
			+ "");
	break;
case 15:
	System.out.println("If you are buying live crabs, it is best to consume them when they are as \nfresh as possible, preferably on the same day, although they will \nkeep safe in the fridge for up to two days. Put the live crabs in a bowl or a container where they can \nstill breathe and cover them with damp paper towels or a damp cloth.");
	break;
case 16:
	System.out.println("Whether they're cooked or raw, prawns should be placed immediately in the\n fridge or freezer and should never be left out in room temperature. \nPrawns should be kept in an airtight container to decrease the chance of bacterial growth, or covered \nvery tightly with plastic.");
	break;
case 17:
	System.out.println("Stand the bag up in the box, pour in the soup and seal the bag. \nPlace it in the freezer. When it's frozen enough to hold its shape, remove the bag from the\n box and freeze. It's best to use soups stored in the refrigerator within 3-4 days for \nbest quality and within six months in the freezer.");
	break;
case 18:
	System.out.println("Cola tend to be more robust than other foods, so a precise temperature \nisn't as important. However, open bottle as less as possible.\r\n"
			+ "");
	break;
case 19:
	System.out.println("First things first: “Always double-wrap your cheese – in waxed paper or \nbaking parchment, ideally – and put it in a plastic container lined with dampened\n kitchen towel or J-cloth.” Then clap on the lid and put it in the top of the fridge – \nthat’s where the temperature is usually the most constant, unless you have a freezer \ncompartment above it – and it’ll keep very happily for as long as it takes to eat it all.");
	break;
case 20:
	System.out.println("Defrosting a whole frozen loaf in the refrigerator overnight is the best \nway; out on the counter it can get soggy, and while it will toast just fine, \nit makes for a better loaf in the fridge.\r\n"
			+ "");
	break;

default:
	System.out.println("Not Possible");
}
	System.out.println("\n----------------------------------------------------------\n");	
	

}

protected void days_left(int r3)//calculates days left
{
int i1=0;
for(i1=0;i1<=19;i1++)
{
da[i1]=ex[i1]-r3;
}
}

public void days_of_selected()//displays days left of individual items
{
int i1=0;
for(i1=0;i1<20;i1++)
{    
if(which[i1]==1)
{
if(da[i1]<=0)
{
arr[0]++;
if(da[i1] !=0 && ((ex[i1]-da[i1])/(-da[i1]))<3)
{
System.out.println("O-: YOUR ITEM: "+ing[i1]+" in the fridge has became INEDIBLE :\n Check the fridge to maintain Hygeine\nDiscard, if Rotten :-O");
System.out.println("O-: For Health Pourpose, the item has been removed from your Cooking List :-O");
System.out.println("If the item seems FINE and you want to Re-enter the item back in the list,\nPress \"Yes\"/\"Y\"/\"1\" \nelse press \"No\"/\"N\"/\"0\" ");
String s1;
aaa:while(true)
{
s1=z.next();
if(s1.equalsIgnoreCase("Yes") || s1.equalsIgnoreCase("Y") ||s1.equals("1"))
break aaa;
else
{
if(s1.equalsIgnoreCase("no") || s1.equalsIgnoreCase("n") ||s1.equals("0"))
{
which[i1]=0;
break aaa;
}
else
System.out.println("Wrong Input :-(\nEnter \"Yes\"/\"Y\"/\"1\" to proceed further \n& \"No\"/N\"/\"0\" to Skip this Step");
}
}
}
else
{
System.out.println(")-: HURRY !!! ITEM: "+ing[i1]+" in the fridge is in CRITICAL State :-(");	
System.out.println("If the item seems ROTTEN and you want to Remove the item from the list, \nPress \"Yes\"/\"Y\"/\"1\"\nPress \"No\"/\"N\"/\"0\" ");
String s1;
aaa:while(true)
{
s1=z.next();
if(s1.equalsIgnoreCase("no") || s1.equalsIgnoreCase("n") ||s1.equals("0"))
break aaa;
else
{
if(s1.equalsIgnoreCase("Yes") || s1.equalsIgnoreCase("Y") ||s1.equals("1"))
{
which[i1]=0;
break aaa;
}
else
System.out.println("Wrong Input :-(\nEnter \"Yes\"/\"Y\"/\"1\" to proceed further \nElse press \"No\"/N\"/\"0\" to Skip this Step");
}
}
}
}

if(da[i1]<=2 && da[i1]>0)
{
arr[1]++;
System.out.println("|-: ITEM: "+ing[i1]+" in the fridge, has about "+ da[i1] + " Days left ONLY!!! :-| ");
}
if(da[i1]>2)
{
arr[2]++;
System.out.println("(-:ITEM: "+ing[i1]+" in the fridge, has about "+ da[i1] + " Days left!!!  :-)");	
}
}			
}
}

protected void selection()//displays items in groups acc. to their days left

{
System.out.println();
int i1=0;
int b=0;
if(arr[0]!=0)
{
System.out.println(")-: Check these first and Proceed!!!As they are ALMOST Rotten :-(");
for(i1=0;i1<20;i1++)
{    
if(which[i1]==1)
{
if(da[i1]<=0)
{
b++;
if(ing[i1].length()<=7)
System.out.print(ing[i1]+"				");	
else
System.out.print(ing[i1]+"			");
if(b%2==0)
System.out.println();
}
}
}
if(b%2!=0)
System.out.println();
b=0;
System.out.println();
}
if(arr[1]!=0)
{
System.out.println("|-: CONSIDER me 1st :-|");
for(i1=0;i1<20;i1++)
{    
if(which[i1]==1)
{
if(da[i1]>0 && da[i1]<=2)
{
b++;
if(ing[i1].length()<=7)
System.out.print(ing[i1]+"				");	
else
System.out.print(ing[i1]+"			");
if(b%2==0)
System.out.println();
}
}
}
if(b%2!=0)
System.out.println();
b=0;
System.out.println();
}
if(arr[2]!=0)
{
System.out.println(":-) Also AVAILABLE (-:");
for(i1=0;i1<20;i1++)
{    
if(which[i1]==1)
{
if(da[i1]>2)
{
b++;
if(ing[i1].length()<=7)
System.out.print(ing[i1]+"				");	
else
System.out.print(ing[i1]+"			");
if(b%2==0)
System.out.println();
}
}
}
if(b%2!=0)
System.out.println();
System.out.println();
}
}

protected int dish()//displays dishes available
{
	
	int i=1;
	if(which[2]==1 && which[0]==1 )
		{
			s=s+"1 ";
			System.out.println(i+".  Scarambled Eggs");
			i++;
		}
		if(which[2]==1 && which[1]==1 && which[0]==1)
		{
			s=s+"2 ";
			System.out.println(i+".  Poarched Eggs");
			i++;
		}
		if(which[2]==1 && which[0]==1 && which[3]==1 && which[6]==1)
		{
			s=s+"3 ";
			System.out.println(i+".  Omelette");
			i++;
		}
		if(which[2]==1 && which[6]==1 )
		{
			s=s+"4 ";
			System.out.println(i+".  Chile Paleno Casserole");
			i++;
		}
		if(which[3]==1 && which[5]==1 )
		{
			s=s+"5 ";
			System.out.println(i+".  Mushroom Casserole");
			i++;
		}if(which[3]==1 && which[4]==1  )
		{
			s=s+"6 ";
			System.out.println(i+".  Low Carb Salad");
			i++;
		}
		if(which[9]==1 && which[3]==1 && which[6]==1 && which[7]==1 && which[4]==1)
		{
			s=s+"7 ";
			System.out.println(i+".  Pan Rosted Chicken");
			i++;
		}
		if(which[9]==1 && which[3]==1 && which[6]==1)
		{
			s=s+"8 ";
			System.out.println(i+".  Indian Tomatino Chicken");
			i++;
		}
		if(which[9]==1 && which[7]==1 && which[3]==1)
		{
			s=s+"9 ";
			System.out.println(+i+".  Chicken Corn Medley");
			i++;
		}
		if(which[9]==1 && which[5]==1 && which[0]==1)
		{
			s=s+"10 ";
			System.out.println(i+".  Garlic Chicken Mushroom Thighs");
			i++;
		}
		if(which[9]==1 && which[11]==1 && which[0]==1 && which[6]==1)
		{
			s=s+"11 ";
			System.out.println(i+".  Chicken Pork Abodo");
			i++;
		}
		if(which[9]==1 && which[12]==1 && which[6]==1)
		{
			s=s+"12 ";
			System.out.println(i+".  Chicken Tuna Salad");
			i++;
		}
		if(which[9]==1 && which[14]==1 && which[18]==1)
		{
			s=s+"13 ";
			System.out.println(i+".  Crab Stuffed Chicken");
			i++;
		}
		if(which[9]==1 && which[6]==1 && which[7]==1)
		{
			s=s+"14 ";
			System.out.println(i+".  Herb Chicken");
			i++;
		}
		if(which[9]==1 && which[0]==1 && which[6]==1)
		{
			s=s+"15 ";
			System.out.println(i+".  Garlic Chicken");
			i++;
		}
		if(which[9]==1&& which[0]==1 && which[18]==1)
		{
			s=s+"16 ";
			System.out.println(i+".  Melt In Your Mouth Chicken");
			i++;
		}
		if(which[9]==1 && which[8]==1)
		{
			s=s+"17 ";
			System.out.println(i+".  Quick And Easy Chicken");
			i++;
		}
		if(which[10]==1 && which[8]==1)
		{
			s=s+"18 ";
			System.out.println(i+".  Chevon Peper Soup");
			i++;
		}
		if(which[10]==1 && which[3]==1 && which[6]==1 )
		{
			s=s+"19 ";
			System.out.println(i+".  Fry Stir Spagheti");
			i++;
		}if(which[10]==1 && which[3]==1 && which[6]==1  )
		{
			s=s+"20 ";
			System.out.println(i+".  Chevon Biryani");
			i++;
		}if(which[14]==1 && which[8]==1 && which[0]==1)
		{
			s=s+"21 ";
			System.out.println(i+".  Crab Curry");
			i++;
		}
		if(which[14]==1 && which[3]==1 && which[6]==1 )
		{
			s=s+"22 ";
			System.out.println(i+".  Crab and Tomato");
			i++;
		}
		if(which[14]==1 && which[19]==1 && which[0]==1 )
		{
			s=s+"23 ";
			System.out.println(i+".  Crab Cake");
			i++;
		}
		if(which[14]==1 && which[6]==1 && which[8]==1)
		{
			s=s+"24 ";
			System.out.println(i+".  Crab Masala Fry");
			i++;
		}
		if(which[15]==1 && which[19]==1)
		{
			s=s+"25 ";
			System.out.println(i+".  Coconut Crimbed Prawns");
			i++;
		}
		if(which[15]==1 && which[8]==1 )
		{
			s=s+"26 ";
			System.out.println(i+".  Garlic and Chorizo Prawns");
			i++;
		}
		if(which[15]==1 && which[9]==1 && which[6]==1)
		{
			s=s+"27 ";
			System.out.println(i+".  Chicken-Prawn Fried Rice");
			i++;
		}
		if(which[12]==1 && which[7]==1 )
		{
			s=s+"28 ";
			System.out.println(i+".  Tuna and Corn Jaffle");
			i++;
		}
		if(which[12]==1 && which[19]==1)
		{
			s=s+"29 ";
			System.out.println(i+".  Tuna Mornay Rissoles");
			i++;
		}
		if(which[12]==1 && which[5]==1 && which[3]==1)
		{
			s=s+"30 ";
			System.out.println(i+".  Tuna Linguine");
			i++;
		}
		if(which[13]==1 && which[5]==1)
		{
			s=s+"31 ";
			System.out.println(i+".  Smoked Salmon Wreath");
			i++;
		}
		if(which[13]==1 && which[0]==1 )
		{
			s=s+"32 ";
			System.out.println(i+".  Salmon Frittata");
			i++;
		}
		if(which[11]==1 && which[8]==1 )
		{
			s=s+"33 ";
			System.out.println(i+".  Pork Dumpling");
			i++;
		}
		if(which[11]==1 )
		{
			s=s+"34 ";
			System.out.println(i+".  Pork Meatball");
			i++;
		}
		if(which[19]==1 && which[2]==1 )
		{
			s=s+"35 ";
			System.out.println(i+".  Bread Quinches");
			i++;
		}
		if(which[19]==1 && which[18]==1 )
		{
			s=s+"36 ";
			System.out.println(i+".  Cheesy Garlic Bread Pull");
			i++;
		}
		if(which[19]==1 && which[18]==1 && which[3]==1 && which[4]==1 && which[6]==1 && which[7]==1)
		{
			s=s+"37 ";
			System.out.println(i+".  Veg. Toast");
			i++;
		}
		
		if(which[16]==1)
		{
			s=s+"38 ";
			System.out.println(i+".  Soup");
			i++;
		}
		
		if(which[17]==1)
		{
			s=s+"39 ";
			System.out.println(i+".  A Refreshing Cola Serve ");
			i++;
		}
		
		if(which[1]==1)
		{
			s=s+"40 ";
			System.out.println(i+".  Arabica Coffee");
			i++;
		}
		if(which[1]==1)
		{
			s=s+"41 ";
			System.out.println(i+".  Robusta Coffee");
			i++;
		}
		if(which[1]==1 && which[8]==1)
		{
			s=s+"42 ";
			System.out.println(i+".  Masala Tea");
			i++;
		}
		if(i==1) 
		{
			if(noit==0)
			{
		System.out.println("\nNO ingredients!! given by you");
		return -1;
			}
			else
			{
				System.out.println("\nNO dishes can be prepaired by given ingredients");
				return -1;
			}
				
		}
		else {
			if(i<=3)
				System.out.println("\nOnly Few Dishes can be prepaired due to less ingredients");	
			return 1;
		}
}

protected void selectdish()//selects dish and displays its recipe
{
	System.out.println("Enter the Dish number from above for Its Recepie");
	int q=z.nextInt();
    String[] ar = s.split(" ",45); 
    String q1=ar[q-1];  
    int q2=Integer.parseInt(q1);
 /**   for (String a : ar) 
        System.out.println(a); */
    switch(q2)
    {
    case 1:
    	System.out.println( "Level: Easy\r\n"
    			+ "Total: 15 min\r\n"
    			+ "Prep: 5 min\r\n"
    			+ "Cook: 10 min\r\n"
    			+ "Directions\r\n"
    			+ "Lightly beat the eggs, 3/4 teaspoon salt and a few grinds of black pepper in a medium bowl.\r\n"
    			+ "Melt 1 tablespoon of the butter in a medium nonstick skillet over low heat; swirl to coat the bottom and sides. Add the eggs, and cook slowly, scraping them up with a rubber spatula occasionally, until most of the liquid has thickened and the eggs are soft, about 10 minutes. (If you like your eggs a little firmer, cook them for an additional 2 to 3 minutes.) Remove them from the heat, and gently fold in the remaining 1 tablespoon of butter. Serve hot.\r\n"
    			+ "");	
    	break;
    	
    case 2:
    	System.out.println("READY IN: 7mins\r\n"
    			+ "SERVES: 3\r\n"
    			+ "DIRECTIONS\r\n"
    			+ "Grease a saucepan with a very small amount of melted butter or margarine (do not use cooking spray it will affect the taste of the eggs).\r\n"
    			+ "Add in cold water to a depth of 2-inches in the saucepan.\r\n"
    			+ "Add in milk and a pinch of salt to the water; bring to a boil then reduce to a light simmer.\r\n"
    			+ "Holding the egg as close as possible to the simmering water break eggs one at a time into the water.\r\n"
    			+ "Simmer over very low heat for 5 minutes or until desired doneness.\r\n"
    			+ "Carefully remove eggs with a slotted spoon."); 
    	break;
    case 3:
    	System.out.println("READY IN: 4mins\r\n"
    			+ "SERVES: 1\r\n"
    			+ "DIRECTIONS\r\n"
    			+ "Crack the eggs into a small bowl and whisk.\r\n"
    			+ "Add some salt and pepper, if you like, but do not add any water, milk, or any other liquids.\r\n"
    			+ "Heat the oil or butter in a 9-inch non-stick frying pan and pour in the eggs.\r\n"
    			+ "In the first 30-seconds of cooking, use a spatula to create 6-10 small cuts through the omelette.\r\n"
    			+ "This allows the uncooked egg on the top to flow down to the bottom of the pan.\r\n"
    			+ "When the top is nearly set, sprinkle any fillings over half of the omelette and turn off the heat.\r\n"
    			+ "Don't worry if some of the egg in the very centre isn't quite set, because the ambient heat will soon cook it.\r\n"
    			+ "Use your spatula to flip one half of the omelette over the other and serve immediately.");
    	break;
    case 4:
    	System.out.println("Ingredients\r\n"
    			+ "1 (5 or 6 oz.) can evaporated milk 4 eggs 12 to 14 chilies or other lg. chilies, roasted & peeled 1 1/2 tsp. baking powder 1/2 tsp. salt 2 tbsp. flour 3/4 lb. \r\n"
    			+ "Directions\r\n"
    			+ "1. After greasing an 8 to 9 inch square pan, place half the chilies and cover with half the cheese. Add another layer of chilies, then another layer of cheese. Beat eggs, add milk, and baking powder, flour and salt. Pour on top. Bake 45 minutes in a 350 degree oven. Serves 6-8.");
    	break;
    case 5:
    	System.out.println("15 mins\r\n"
    			+ "Cook:\r\n"
    			+ "45 mins\r\n"
    			+ "Total:\r\n"
    			+ "1 hr\r\n"
    			+ "Servings:\r\n"
    			+ "6\r\n"
    			+ "Yield:\r\n"
    			+ "6 servings\r\n"
    			+ "DirectionsInstructions Checklist\r\n"
    			+ "Step 1\r\n"
    			+ "Preheat oven to 350 degrees F (175 degrees C). Place bacon in a large, deep skillet. Cook over medium-high heat until crisp and evenly brown; drain. Chop bacon, and set aside.\r\n"
    			+ "\r\n"
    			+ "Step 2\r\n"
    			+ "Cut corn from cobs. There should be about 4 or 5 cups of corn kernels. Melt butter in a large skillet over medium heat. Add the corn, and cook for about 5 minutes, stirring constantly. Stir in the bacon and salt, and remove from heat.\r\n"
    			+ "\r\n"
    			+ "Step 3\r\n"
    			+ "Spread a layer of the corn mixture into the bottom of a 2-quart casserole dish, then layer with tomatoes. Repeat layers twice, ending with tomatoes on the top.\r\n"
    			+ "\r\n"
    			+ "Step 4\r\n"
    			+ "Bake uncovered in preheated oven for 30 minutes, or until corn is tender.");
    	break;
    case 6:
    	System.out.println("In large bowl, whisk together olive oil, lemon juice, Dijon mustard, sugar, salt, and pepper.\r\n"
    			+ "Add mixed greens; toss to combine");
    	break;
    case 7:
    	System.out.println("Ingredients\r\n"
    			+ "2 pounds red potatoes (about 6 medium), cut into 3/4-inch pieces\r\n"
    			+ "1 large onion, coarsely chopped\r\n"
    			+ "2 tablespoons olive oil\r\n"
    			+ "3 garlic cloves, minced\r\n"
    			+ "1-1/4 teaspoons salt, divided\r\n"
    			+ "1 teaspoon dried rosemary, crushed, divided\r\n"
    			+ "3/4 teaspoon pepper, divided\r\n"
    			+ "1/2 teaspoon paprika\r\n"
    			+ "6 bone-in chicken thighs (about 2-1/4 pounds), skin removed\r\n"
    			+ "6 cups fresh baby spinach (about 6 ounces)\r\n"
    			+ "Directions\r\n"
    			+ "Preheat oven to 425°. In a large bowl, combine potatoes, onion, oil, garlic, 3/4 teaspoon salt, 1/2 teaspoon rosemary and 1/2 teaspoon pepper; toss to coat. Transfer to a 15x10x1-in. baking pan coated with cooking spray.\r\n"
    			+ "In a small bowl, mix paprika and the remaining salt, rosemary and pepper. Sprinkle chicken with paprika mixture; arrange over vegetables. Roast until a thermometer inserted in chicken reads 170°-175° and vegetables are just tender, 35-40 minutes.\r\n"
    			+ "Remove chicken to a serving platter; keep warm. Top vegetables with spinach. Roast until vegetables are tender and spinach is wilted, 8-10 minutes longer. Stir vegetables to combine; serve with chicken.");
    	break;
    case 8:
    	System.out.println("\r\n"
    			+ "Ingredient Checklist\r\n"
    			+ "Chicken\r\n"
    			+ "1 large onion, chopped\r\n"
    			+ "4 cloves garlic, chopped\r\n"
    			+ "1 slice fresh ginger root\r\n"
    			+ "1 tablespoon olive oil\r\n"
    			+ "2 teaspoons ground cumin\r\n"
    			+ "1 teaspoon ground turmeric\r\n"
    			+ "1 teaspoon salt\r\n"
    			+ "1 teaspoon ground black pepper\r\n"
    			+ "DirectionsInstructions Checklist\r\n"
    			+ "Step 1\r\n"
    			+ "Place onion, garlic and ginger in a food processor and process into a paste. Heat oil in a large skillet over medium heat, add onion paste and saute, stirring continuously, for about 10 minutes.\r\n"
    			+ "\r\n"
    			+ "Step 2\r\n"
    			+ "Stir in the cumin, turmeric, salt, pepper, cardamom, cinnamon, cloves, bay leaves and nutmeg. Saute, stirring, for 1 to 2 minutes. Place chicken pieces in skillet and stir them around with the spice mixture until they are well coated.\r\n"
    			+ "\r\n"
    			+ "Step 3\r\n"
    			+ "Saute for another 4 minutes, then pour in the tomatoes with liquid and stir. Reduce heat to low and simmer for 1 to 2 hours, or until the oil has separated from the liquid. Stir occasionally. (Note: If you simmer uncovered, the sauce will thicken; add water, or keep covered while simmering.)\r\n"
    			+ "");
    	break;
    case 9:
    	System.out.println("Ingredients\r\n"
    			+ "3/4 cup all-purpose flour\r\n"
    			+ "2 teaspoons salt, divided\r\n"
    			+ "3/4 teaspoon pepper, divided\r\n"
    			+ "4 boneless skinless chicken breast halves (4 ounces each), thinly sliced\r\n"
    			+ "2 tablespoons canola oil\r\n"
    			+ "1-1/2 cups chopped onion\r\n"
    			+ "Directions\r\n"
    			+ "In a large resealable plastic bag, combine the flour, 1 teaspoon salt and 1/2 teaspoon pepper. Add chicken, a few pieces at a time, and shake to coat.\r\n"
    			+ "In a large skillet, brown chicken in oil until chicken is no longer pink; remove and set aside. In the drippings, saute onion until tender.\r\n"
    			+ "Toss mushrooms with lemon juice. Add mushroom mixture to the skillet; cook and stir for 4 minutes or until vegetables are tender. Add garlic; cook 1 minute longer. Stir in the broth, mustard, basil, oregano, cayenne pepper, remaining salt and pepper and chicken. Simmer, uncovered, for 15 minutes.\r\n"
    			+ "Stir in the corn, tomatoes and green pepper; simmer for 10 minutes longer or until heated through. Sprinkle with parsley. Serve with noodles or rice if desired.\r\n"
    			+ "");
    	break;
    case 10:
    	System.out.println("INGREDIENTS\r\n"
    			+ "For The Chicken:\r\n"
    			+ "1 1/2 pounds (700g) boneless skinless chicken thighs (around 6-8 fillets)\r\n"
    			+ "For The Sauce:\r\n"
    			+ "1 tablespoon butter\r\n"
    			+ "8 ounces (250 g) sliced brown mushrooms\r\n"
    			+ "4 cloves garlic, minced (or 1 tablespoon minced garlic)\r\n"
    			+ "1 tablespoon fresh chopped parsley\r\n"
    			+ "1/2 - 1 teaspoon each of dried thyme and dried rosemary (adjust to your taste)\r\n"
    			+ "INSTRUCTIONS\r\n"
    			+ "Pat chicken thighs dry with paper towel and trim off excess fat. Combine the onion powder, garlic powder, herbs, salt and pepper. Coat the chicken evenly with the combined seasoning.\r\n"
    			+ "Heat 1 tablespoon of oil a large pan or skillet over medium-high heat and sear chicken thighs in batches until browned on each side and no longer pink in centre (about 8 minutes each side, depending on thickness). Add remaining oil if needed for second batch. Transfer to a plate; set aside and keep warm.\r\n"
    			+ "To the same pan or skillet, melt the butter and add the mushrooms. Season with salt and pepper and cook until soft (about 3 minutes). Add the garlic, parsley, thyme and rosemary; sauté until fragrant (about 1 minute).\r\n"
    			+ "\r\n"
    			+ "Return chicken to the pan. Taste test and season with salt and pepper to your taste. Garnish with fresh parsley. Serve immediately.");
    	break;
    case 11:
    	System.out.println("Ingredients\r\n"
    			+ "1 1/2 lbs pork belly chopped\r\n"
    			+ "1 1/2 lbs chicken cut into serving pieces\r\n"
    			+ "4 pieces dried bay leaves\r\n"
    			+ "2 teaspoons whole peppercorn\r\n"
    			+ "1 head garlic slightly crushed\r\n"
    			+ "6 tablespoons vinegar white\r\n"
    			+ "1/2 cup soy sauce\r\n"
    			+ "1 tablespoon oyster sauce\r\n"
    			+ "2 teaspoons brown sugar\r\n"
    			+ "2 cups water\r\n"
    			+ "Salt to taste\r\n"
    			+ "3 tablespoons cooking oil\r\n"
    			+ "Instructions\r\n"
    			+ "Heat oil in a pan\r\n"
    			+ "Once the oil becomes hot, add the garlic. Cook until the color turns golden brown.\r\n"
    			+ "Remove the garlic and set aside. Add pork and chicken. Cook for 5 minutes or until the color turns light brown.\r\n"
    			+ "Add whole peppercorn, bay leaves, oyster sauce, soy sauce, and water. Let boil and simmer until the meat gets tender.\r\n"
    			+ "Add the sugar and stir.\r\n"
    			+ "Pour-in vinegar and let boil.Simmer until most of the liquid evaporates.\r\n"
    			+ "Add salt to taste. Put-in the fried garlic, stir, and cook for 2 minutes.\r\n"
    			+ "Serve. Share and enjoy!\r\n"
    			+ "");
    	break;
    case 12:
    	System.out.println("INGREDIENTS\r\n"
    			+ "Nutrition\r\n"
    			+ "1\r\n"
    			+ "(12 1/2 ounce) can chicken breasts\r\n"
    			+ "1\r\n"
    			+ "(6 ounce) can solid white tuna\r\n"
    			+ "1⁄3\r\n"
    			+ "cup mayonnaise\r\n"
    			+ "2\r\n"
    			+ "tablespoons honey mustard\r\n"
    			+ "1⁄4\r\n"
    			+ "cup apricot preserves\r\n"
    			+ "3\r\n"
    			+ "tablespoons sweet pickle relish\r\n"
    			+ "1⁄2\r\n"
    			+ "red apple, cored, chopped\r\n"
    			+ "1\r\n"
    			+ "cup dark raisin\r\n"
    			+ "1⁄8\r\n"
    			+ "teaspoon pepper\r\n"
    			+ "DIRECTIONS\r\n"
    			+ "Drain the chicken & albacore & shred them in a bowl.\r\n"
    			+ "Add the mayonnaise, mustard, preserves & pickle relish.\r\n"
    			+ "Quarter the unpeeled apple & get rid of the core.\r\n"
    			+ "Stand each quarter apple on its edge and slice each in half lengthwise, keeping the red halves.\r\n"
    			+ "Dice these red halves & add to chicken/albacore mix, along with the raisins.\r\n"
    			+ "Mix well & season with pepper to taste.\r\n"
    			+ "Refrigerate.");
    	break;
    case 13:
    	System.out.println("Original recipe yields 4 servings\r\n"
    			+ "Ingredient Checklist\r\n"
    			+ "3 ounces cream cheese, softened\r\n"
    			+ "1 teaspoon chopped fresh dill\r\n"
    			+ "1 teaspoon minced garlic\r\n"
    			+ "⅛ teaspoon lemon pepper\r\n"
    			+ "4 ounces fresh Dungeness crabmeat\r\n"
    			+ "4 skinless, boneless chicken breasts\r\n"
    			+ "\r\n"
    			+ "\r\n"
    			+ "Directions Instructions \r\n"
    			+ "Step 1\r\n"
    			+ "In a medium bowl combine the cream cheese, onion, parsley, dill, garlic and lemon pepper. Add crabmeat and mix thoroughly. Season with salt and pepper to taste. Cover and chill in refrigerator (can be prepared 2 hours ahead).\r\n"
    			+ "\r\n"
    			+ "Step 2\r\n"
    			+ "Using a small sharp knife, cut in half horizontally through the center of each chicken breast half, creating a pocket. Fill each pocket with 1/4 of the crab stuffing. Then dip each chicken piece into flour, eggs and finally bread crumbs to coat. Cover completely.\r\n"
    			+ "\r\n"
    			+ "Step 3\r\n"
    			+ "In a large skillet melt butter or margarine with oil over medium heat. Add filled, breaded chicken breast halves to skillet and saute until golden brown and cooked through (juices run clear), about 10 minutes each side. Remove from skillet, drain on paper towels and serve.");
    	break;
    case 14:
    	System.out.println("INGREDIENTS\r\n"
    			+ "For The Chicken:\r\n"
    			+ "4 chicken breasts (pounded 1/2-inch thin)\r\n"
    			+ "2 teaspoons each of onion powder and garlic powder\r\n"
    			+ "1 teaspoon fresh chopped parsley\r\n"
    			+ "1/2 teaspoon each of dried thyme and dried rosemary*\r\n"
    			+ "salt and pepper , to season\r\n"
    			+ "For The Sauce:\r\n"
    			+ "4 cloves garlic , minced (or 1 tablespoon minced garlic)\r\n"
    			+ "1 teaspoon fresh chopped parsley\r\n"
    			+ "1/2 teaspoon each of dried thyme and dried rosemary\r\n"
    			+ "1 cup milk (or half and half)*\r\n"
    			+ "Salt and freshly ground black pepper , to taste\r\n"
    			+ "1 teaspoon cornstarch mixed with 1 tablespoon water , until smooth\r\n"
    			+ "INSTRUCTIONS\r\n"
    			+ "Coat chicken breasts with the onion and garlic powders and herbs. Season generously with salt and pepper.\r\n"
    			+ "Heat 1 tablespoon of oil a large pan or skillet over medium-high heat and cook chicken breasts until opaque and no longer pink inside (about 5 minutes each side, depending on thickness). Transfer to a plate; set aside.\r\n"
    			+ "To the same pan or skillet, heat another 2 teaspoons of olive oil and sauté garlic, with parsley, thyme and rosemary, for about 1 minute, or until fragrant.\r\n"
    			+ "Stir in milk (or cream); season with salt and pepper, to taste.\r\n"
    			+ "Bring to a boil; add the cornstarch mixture to the centre of the pan, quickly stirring, until sauce has thickened slightly. Reduce heat and simmer gently for a further minute to allow the sauce to thicken more.\r\n"
    			+ "");
    	break;
    case 15:
    	System.out.println("Ingredients\r\n"
    			+ "Serving\r\n"
    			+ "4\r\n"
    			+ "\r\n"
    			+ "Original recipe yields 4 servings\r\n"
    			+ "Ingredient Checklist\r\n"
    			+ "¼ cup olive oil\r\n"
    			+ "2 cloves garlic, crushed\r\n"
    			+ "¼ cup Italian-seasoned bread crumbs\r\n"
    			+ "¼ cup grated Parmesan cheese\r\n"
    			+ "4 skinless, boneless chicken breast halves\r\n"
    			+ "\r\n"
    			+ "DirectionsInstructions Checklist\r\n"
    			+ "Step 1\r\n"
    			+ "Preheat oven to 425 degrees F (220 degrees C).\r\n"
    			+ "\r\n"
    			+ "Step 2\r\n"
    			+ "Heat olive oil and garlic in a small saucepan over low heat until warmed, 1 to 2 minutes. Transfer garlic and oil to a shallow bowl.\r\n"
    			+ "\r\n"
    			+ "Step 3\r\n"
    			+ "Combine bread crumbs and Parmesan cheese in a separate shallow bowl.\r\n"
    			+ "\r\n"
    			+ "Step 4\r\n"
    			+ "Dip chicken breasts in the olive oil-garlic mixture using tongs; transfer to bread crumb mixture and turn to evenly coat. Transfer coated chicken to a shallow baking dish.\r\n"
    			+ "\r\n"
    			+ "Step 5\r\n"
    			+ "Bake in the preheated oven until no longer pink and juices run clear, 30 to 35 minutes. An instant-read thermometer inserted into the center should read at least 165 degrees F (74 degrees C).");
    	break;
    case 16:
    	System.out.println("Ingredients:\r\n"
    			+ "\r\n"
    			+ "1 cup sour cream\r\n"
    			+ "2 teaspoons garlic powder\r\n"
    			+ "1 teaspoon seasoned salt\r\n"
    			+ "1/2 teaspoon fresh ground black pepper\r\n"
    			+ "1 1/2 cups freshly grated Parmesan cheese, divided\r\n"
    			+ "3 pounds boneless chicken breasts, trimmed of excess fat\r\n"
    			+ "Instructions\r\n"
    			+ "Preheat oven to 375°F. Lightly coat a 9×13 baking dish with nonstick spray and set aside.\r\n"
    			+ "In a medium bowl, mix together the sour cream, garlic powder, seasoned salt, pepper, and 1 cup of Parmesan cheese.\r\n"
    			+ "\r\n"
    			+ "Place the chicken breasts evenly into the pan. Spread the sour cream mixture on top of the chicken. Sprinkle with the remaining Parmesan cheese.\r\n"
    			+ "Bake for 25-30 minutes, or until the chicken is cooked through.\r\n"
    			+ "Turn the oven to broil and place the pan under the broiler for 2-3 minutes until lightly browned on top.\r\n"
    			+ "Serve immediately.");
    	break;
    	
    case 17:
    	System.out.println("Ingredients\r\n"
    			+ "Serving\r\n"
    			+ "4\r\n"
    			+ "Original recipe yields 4 servings\r\n"
    			+ "Ingredient Checklist\r\n"
    			+ "2 tablespoons olive oil\r\n"
    			+ "1 onion, chopped\r\n"
    			+ "4 skinless, boneless chicken breast halves\r\n"
    			+ "3 tablespoons ketchup\r\n"
    			+ "2 tablespoons soy sauce\r\n"
    			+ "3 tablespoons white sugar\r\n"
    			+ "2 tablespoons lemon juice\r\n"
    			+ "\r\n"
    			+ "DirectionsInstructions Checklist\r\n"
    			+ "Step 1\r\n"
    			+ "Saute onion in oil until translucent.\r\n"
    			+ "\r\n"
    			+ "Step 2\r\n"
    			+ "Add chicken, and brown lightly.\r\n"
    			+ "\r\n"
    			+ "Step 3\r\n"
    			+ "Combine ketchup, soy sauce, sugar, lemon juice, and pepper; mix well. Pour over chicken, and bring to a boil. Cover, reduce heat, and simmer for 25 to 35 minutes.");
    	break;
   
    case 18:
    	System.out.println("Ingredients\r\n"
    			+ "1/2 kg Goat meat\r\n"
    			+ "6-8 scotch bonnet pepper\r\n"
    			+ "9-12 scent leaves (nchuanwu in Igbo)\r\n"
    			+ "1 teaspoon blended Ehuru seeds(African nutmeg)\r\n"
    			+ "1 bulb red onion\r\n"
    			+ "1 ginger root\r\n"
    			+ "3 cloves garlic\r\n"
    			+ "Salt (to taste)\r\n"
    			+ "Seasoning (to taste)\r\n"
    			+ "Steps\r\n"
    			+ "Wash the meat and add into a cooking pot.\r\n"
    			+ "Season with chopped onion, garlic and ginger. start cooking till soft\r\n"
    			+ "Add in the blended Ehuru seeds, and blended pepper then allow simmer for another 2minutes\r\n"
    			+ "Taste for salt before adding more salt and seasoning\r\n"
    			+ "Add the chopped nchuanwu leaves and let simmer for 1 minute and it's ready to eat\r\n"
    			+ "Serve hot with either boiled rice, Yam or white Agidi\r\n"
    			+ "");
    	break;
    case 19:
    	System.out.println("Ingredients\r\n"
    			+ " 3 servings\r\n"
    			+ "Chevon (cooked)\r\n"
    			+ "2 cups Chevon stock\r\n"
    			+ "Green bonnet pepper\r\n"
    			+ "Red bonnet pepper\r\n"
    			+ "1 sachet spaghetti\r\n"
    			+ "1 Onions\r\n"
    			+ "cubes Seasoning\r\n"
    			+ "3/4 cup Vegetable oil\r\n"
    			+ "2 Ripe plantains\r\n"
    			+ "Curry\r\n"
    			+ "Thyme\r\n"
    			+ "Salt\r\n"
    			+ "Water\r\n"
    			+ "Steps\r\n"
    			+ "Parboil the spaghetti for 7mins\r\n"
    			+ "Dice the chevon, bonnet peppers, plantain, onions separately\r\n"
    			+ "Stir-fry the diced ingredients in vegetable oil at moderate heat\r\n"
    			+ "Add the chevon stock\r\n"
    			+ "Add two seasoning cubes, curry and thyme\r\n"
    			+ "Add the parboiled spaghetti and a cup of water\r\n"
    			+ "Cover with lid and allow it to cook for ten minutes\r\n"
    			+ "Add salt-to-taste and allow to simmer for 3 - 5 minutes.");
    	break;
     case 20:
    	System.out.println("Ingredients\r\n"
    			+ " 3 servings\r\n"
    			+ "1500 g Parboiled Rice\r\n"
    			+ "Fried Chevon\r\n"
    			+ "Sunflower Oil\r\n"
    			+ "Green Peas\r\n"
    			+ "Diced Green Pepper\r\n"
    			+ "Diced Onions\r\n"
    			+ "Diced Garlic\r\n"
    			+ "Crushed Ginger\r\n"
    			+ "All Purpose Seasoning\r\n"
    			+ "Black Pepper\r\n"
    			+ "Seasoning Cubes 3\r\n"
    			+ "Salt1tsp\r\n"
    			+ "Curry Masala\r\n"
    			+ "Tomato Puree\r\n"
    			+ "Coconut powder 1cksp\r\n"
    			+ "Steps\r\n"
    			+ "Heat oil in a pot,add onions,ginger and garlic, stir fry for 1min on medium heat,add tomatoes puree,,seasoning cube s,fry for 2mins, add water,green peas, all purpose seasoning,curry masala,bring to boil, coconut powder,add rice(note,water must be same Level as Rice),bring to boil, adjust with salt and seasoning,if water dries, add little more till soft,add carrot before water dries, when done, add green pepper last,stir,cover for 7scs,remove from heat, plate and garnish with fried chevon,enjoy!");
    	break;
     case 21:
    	System.out.println("Ingredients\r\n"
    			+ " 4 servings\r\n"
    			+ "500 grams Crabs\r\n"
    			+ "2 cups Onion sliced\r\n"
    			+ "1/2 cup Onion paste\r\n"
    			+ "2 tbsp Ginger garlic paste\r\n"
    			+ "1/2 cup Tomato puree\r\n"
    			+ "4 tbsp Turmeric powder\r\n"
    			+ "4 tsp Kasmiri chilli powder\r\n"
    			+ "to taste Salt\r\n"
    			+ "1 tsp Garam masala powder\r\n"
    			+ "3 tsp Black pepper powder\r\n"
    			+ "2 tbsp Mustard oil\r\n"
    			+ "3 Potato, medium size\r\n"
    			+ "Steps\r\n"
    			+ "First marinate the crabs with salt and turmeric for 15 minutes.Then fry them till it turns bright red colour from all sides.Fry the diced potatoes and keep aside.\r\n"
    			+ "Heat oil in kadai.now add onions,when light brown add chilli powder, turmeric powder, Ginger garlic paste and onion paste to it.saute for 5 minutes.then add tomato puree.\r\n"
    			+ "Cook covered till oil starts leaving from the masala.Add salt to it.mix well,add crabs and cook covered on low heat for 10 minutes,stir occasionally.\r\n"
    			+ "Add fried potatoes to it,mix well,keep partial covered,add garam masala and black pepper to it. Continue cooking for another 10 minutes on low heat.");
    	break;
     case 22:
    	System.out.println("Ingredients\r\n"
    			+ "1 kg Crab\r\n"
    			+ "4 slices onions\r\n"
    			+ "3 tomatoes\r\n"
    			+ "2 sprig curry leaves\r\n"
    			+ "2 green chillies\r\n"
    			+ "1 tsp fenugreek\r\n"
    			+ "1 tsp red chilli powder\r\n"
    			+ "1 tsp turmeric powder\r\n"
    			+ "1/2 cup grated coconut\r\n"
    			+ "1 tbsp pepper corns\r\n"
    			+ "1 tbsp coriander seeds\r\n"
    			+ "1/2 tbsp cumin seed\r\n"
    			+ "1/2 tbsp fennel seed\r\n"
    			+ "1 cinnamon stick\r\n"
    			+ "4 dry red chilli\r\n"
    			+ "4 tbsp gingelly oil\r\n"
    			+ "1/4 cup chopped coriander\r\n"
    			+ "To taste Salt\r\n"
    			+ "Steps\r\n"
    			+ "Dry roast grated coconut, cumin seed,coriander seed,fennel seed, pepper corns, dry red chilli, cinnamon sticks.\r\n"
    			+ "Grind it into smooth paste and keep it aside.\r\n"
    			+ "Heat oil in a kadhai and add methi seeds and sliced onions,saute and cook till it turns to golden brown.\r\n"
    			+ "Add curry leaves,green chillies,salt and tomatoes.close and cook till it becomes mushy.\r\n"
    			+ "Add red chilli powder, turmeric powder and the grinded paste.\r\n"
    			+ "Mix well and cook for 5-8 minutes\r\n"
    			+ "Add water and allow it to boil.\r\n"
    			+ "Then finally add cleaned crab.Mix altogether and close the kadhai and cook till the crab is cooked completely.\r\n"
    			+ "Once the crab is cooked,garnish with some chopped coriander and serve.\r\n"
    			+ "");
    	break;
    case 23:
    	System.out.println("INGREDIENTS\r\n"
    			+ "1/3 c. mayonnaise\r\n"
    			+ "1 large egg, beaten\r\n"
    			+ "2 tbsp. Dijon mustard\r\n"
    			+ "2 tsp. Worcestershire sauce\r\n"
    			+ "1/2 tsp. hot sauce\r\n"
    			+ "Kosher salt\r\n"
    			+ "Freshly ground black pepper\r\n"
    			+ "DIRECTIONS\r\n"
    			+ "In a small bowl, whisk together mayo, egg, Dijon mustard, Worcestershire, and hot sauce, and season with salt and pepper.\r\n"
    			+ "In a medium bowl, stir together crabmeat, panko, and parsley. Fold in mayo mixture, then form into 8 patties.\r\n"
    			+ "In a large skillet over medium-high heat, coat pan with oil and heat until shimmering. Add crab cakes and cook, in batches, until golden and crispy, 3 to 5 minutes per side.\r\n"
    			+ "Serve with lemon and tartar sauce.\r\n"
    			+ "");
    	break;
    case 24:
    	System.out.println("Ingredients\r\n"
    			+ "3 tablespoons vegetable oil, divided\r\n"
    			+ "1 medium onion, finely chopped (about 1 cup), divided\r\n"
    			+ "1 tablespoon coriander seeds\r\n"
    			+ "1/2 tablespoon cumin seeds\r\n"
    			+ "1 whole small dried red chili, such as Thai bird or chile de árbol\r\n"
    			+ "5 whole black peppercorns\r\n"
    			+ "2 whole cloves\r\n"
    			+ "1 inch piece of ginger, minced (about 1 tablespoon)\r\n"
    			+ "3 medium cloves garlic , minced (about 1 tablespoon)\r\n"
    			+ "1 teaspoon fennel seeds\r\n"
    			+ "1 cup tomato puree\r\n"
    			+ "Directions\r\n"
    			+ "1.\r\n"
    			+ "Heat 1 tablespoon oil in a heavy-bottomed saucepan over low heat until shimmering. Add 1 tablespoon chopped onion, coriander seeds, cumin seeds, dried chili, peppercorns, cloves, ginger, and garlic. Cook, stirring frequently, until fragrant, about 5 minutes. Turn off the heat and add fennel seeds. Stir to mix through. Immediately transfer to the bowl of a blender or mortar and pestle and blend/pound until a fine paste is formed, scraping down sides as necessary.\r\n"
    			+ "\r\n"
    			+ "2.\r\n"
    			+ "Wipe out saucepan with a paper towel and add remaining oil. Heat over medium heat until shimmering. Add the remaining onion. Cook, stirring, unti lightly browned, about 6 minutes. Add the tomato puree, bring to a simmer, and simmer for 5 minutes. Add turmeric powder and the ground spice paste. Stir well to combine and continue to cook, stirring occasionally, until the oil separates and starts surfacing. Add a few drops of water if the paste tends to stick or get too dry.\r\n"
    			+ "\r\n"
    			+ "3.\r\n"
    			+ "Add the crab and salt. Spoon some of the sauce over the crab to coat. Cover and cook for 5 minute. Remove lid, stir, and continue to cook for 10 minutes, spooning the sauce over the crabs occasionally. Sprinkle with coriander leaves and serve immediately with rice or bread.\r\n"
    			+ "");
    	break;
    
    case 25:
    	System.out.println("INGREDIENTS\r\n"
    			+ "8 large green king prawns, peeled, deveined, tails intact\r\n"
    			+ "1/4 cup plain flour\r\n"
    			+ "1 egg\r\n"
    			+ "1/2 cup shredded coconut\r\n"
    			+ "1/2 cup panko breadcrumbs (see note)\r\n"
    			+ "Vegetable oil, for shallow-frying\r\n"
    			+ "LIME AIOLI\r\n"
    			+ "1/4 cup whole-egg mayonnaise\r\n"
    			+ "1 small garlic clove, crushed\r\n"
    			+ "METHOD\r\n"
    			+ "Step 1\r\n"
    			+ "Using the palm of your hand, slightly flatten prawns. Place flour in a bowl. Add prawns. Toss to coat.\r\n"
    			+ "Step 2\r\n"
    			+ "Whisk egg and 2 tablespoons cold water together in a shallow bowl. Combine coconut and breadcrumbs on a plate. Dip 1 prawn in egg mixture, then breadcrumb mixture. Place on a plate. Repeat with remaining prawns, egg mixture and breadcrumb mixture.\r\n"
    			+ "Step 3\r\n"
    			+ "Heat oil in a large frying pan. Cook prawns for 2 minutes each side or until golden and cooked through.\r\n"
    			+ "Step 4\r\n"
    			+ "Meanwhile, make aioli Place mayonnaise, garlic, lime rind and lime juice in a bowl. Stir to combine.\r\n"
    			+ "Step 5\r\n"
    			+ "Serve prawns with aioli.\r\n"
    			+ "");
    	break;
    case 26:
    	System.out.println("INGREDIENTS\r\n"
    			+ "2 large chorizo sausages, thinly sliced\r\n"
    			+ "125ml (1/2 cup) olive oil\r\n"
    			+ "6 garlic cloves, crushed\r\n"
    			+ "2kg medium green tiger prawns, peeled leaving tails intact \r\n"
    			+ "1/2 cup chopped fresh coriander\r\n"
    			+ "1 tablespoon dry sherry\r\n"
    			+ "Lemon wedges, to serve\r\n"
    			+ "METHOD\r\n"
    			+ "Step 1\r\n"
    			+ "Heat a large non-stick frying pan over high heat. Add the chorizo and cook, stirring occasionally, for 4-5 minutes or until golden and crisp. Use a slotted spoon to transfer the chorizo to a plate lined with paper towel.\r\n"
    			+ "Step 2\r\n"
    			+ "Reduce heat to low. Add the oil and garlic to the pan and cook, stirring, for 1 minute or until aromatic. Add the prawns and cook, stirring occasionally, for 4-5 minutes or until the prawns curl and change colour. Add the chorizo, coriander and sherry to the pan and stir to combine.\r\n"
    			+ "Step 3\r\n"
    			+ "Divide the prawn mixture among serving bowls. Serve with lemon wedges and crusty bread.\r\n"
    			+ "");	
    	break;
    case 27:
    	System.out.println("INGREDIENTS\r\n"
    			+ " \r\n"
    			+ "\r\n"
    			+ "▢1 tbsp olive oil\r\n"
    			+ "▢1 large onion - finely chopped\r\n"
    			+ "▢1 stick celery - chopped\r\n"
    			+ "▢Pinch of salt\r\n"
    			+ "▢2 cloves of garlic - peeled and finely chopped\r\n"
    			+ "▢3 chicken breasts - chopped into chunks\r\n"
    			+ "▢120 g chorizo - chopped into chunks\r\n"
    			+ "▢1 red pepper - chopped\r\n"
    			+ "▢450 g long grain rice\r\n"
    			+ "DIRECTIONS\r\n"
    			+ "1.Heat the olive oil in a large casserole pan, add in the onions, celery and a pinch of salt.  Cook on a low heat for about 5 minutes until the onions have softened.  \r\n"
    			+ "Onions and garlic cooking in a pan\r\n"
    			+ "2.Add in the garlic and continue to cook for another minute, then add in the chicken and cook (giving it the occasional stir) for about 5 mins until the chicken is sealed.\r\n"
    			+ "3.Adding chicken to a pan of cooked onions\r\n"
    			+ "4.Add in the chorizo and cook for another couple of minutes, then add in the red peppers, cook for another minute before adding the rice.  \r\n"
    			+ "5.Rice being poured into a pan of chicken and chorizo for jambalaya\r\n"
    			+ "Given the rice a stir and add in the Cajun spice, paprika and tomato puree. Stir together until everything is coated in the spices.\r\n"
    			+ "6.Pan of chicken. chorizo, rice and spices for jambalaya. Once it’s reached bubbling point, place the lid on and turn the heat down so that the dish is barely bubbling. Cook for about 20 minutes, giving it a stir every so often to prevent the rice from sticking. You may find that the rice is starting to look too dry, if so, add some more stock.\r\n"
    			+ "7.Placing a lid on a pan of jambalaya\r\n"
    			+ "After the 20 mins are up, add in the chopped okra, give everything a stir, add a bit more of the stock if needed, place the lid back on a cook for another 5 mins.\r\n"
    			+ "8.Close up image of slicing okra\r\n"
    			+ "After the 5 mins, test the rice, if it’s nearly cooked, place the prawns (shrimp) on top, put the lid back on and cook for a further 5 mins.  If the rice is still hard, continue to cook (adding a little more stock water again if needed) until it’s nearly ready before adding the prawns.\r\n"
    			+ "9.Once cooked, sprinkle on the chopped spring onions/scallions and serve with wedges of lemon.\r\n"
    			+ "");	
    	break;
    case 28:
    	System.out.println("INGREDIENTS\r\n"
    			+ "95g can tuna in olive oil, drained, flaked\r\n"
    			+ "1/3 cup grated tasty cheese\r\n"
    			+ "125g can corn kernels, drained\r\n"
    			+ "6 slices bread and butter pickles, finely chopped\r\n"
    			+ "1/4 red onion, finely chopped\r\n"
    			+ "1 tablespoon Japanese-style mayonnaise\r\n"
    			+ "METHOD\r\n"
    			+ "Step 1\r\n"
    			+ "Preheat jaffle maker.\r\n"
    			+ "Step 2\r\n"
    			+ "Meanwhile, combine tuna, cheese, corn, pickles, onion, mayonnaise and parsley in a bowl. Season with salt and pepper.\r\n"
    			+ "Step 3\r\n"
    			+ "Spread butter over 1 side of each slice of bread. Place 1 slice of bread, buttered- side down, in each hole of jaffle maker. Top evenly with tuna mixture. Sandwich with remaining bread slices, buttered-side up. Close lid. Cook for 4 minutes or until golden and cheese is melted. Serve with extra parsley.\r\n"
    			+ "");	
    	break;
    case 29:
    	System.out.println("INGREDIENTS\r\n"
    			+ "400g microwave baby potatoes\r\n"
    			+ "350g packet kale slaw mix\r\n"
    			+ "2 x 425g cans tuna in brine, drained\r\n"
    			+ "425g tub creamy cheese pasta sauce\r\n"
    			+ "50g (1 cup) panko breadcrumbs\r\n"
    			+ "METHOD\r\n"
    			+ "Step 1\r\n"
    			+ "Microwave the potatoes following packet directions. Use a fork to coarsely mash, including the skin. Make the slaw following packet directions.\r\n"
    			+ "Step 2\r\n"
    			+ "Combine tuna and 250ml (1 cup) pasta sauce in a large bowl. Add potato and mix until well combined. Season. Place breadcrumbs on a plate. Shape tuna mixture into 16 patties. Roll patties in breadcrumbs to coat.\r\n"
    			+ "Step 3\r\n"
    			+ "Add oil to a large frying pan to come 1cm up side of pan. Heat over medium-high heat. Cook patties, in 2 batches, for 2 minutes each side or until golden. Transfer to a plate lined with paper towel. Microwave the remaining sauce in a microwavesafe bowl for 1 minute or until heated. Stir through parsley. Divide slaw and patties among serving plates. Top with sauce, extra parsley and lemon.\r\n"
    			+ "");
    	break;
    case 30:
    	System.out.println("INGREDIENTS\r\n"
    			+ "375g linguine\r\n"
    			+ "2 tbs extra virgin olive oil\r\n"
    			+ "250g vine-ripened cherry tomatoes \r\n"
    			+ "2 zucchini, thinly sliced\r\n"
    			+ "2 flat mushrooms, thinly sliced\r\n"
    			+ "2 garlic cloves, thinly sliced\r\n"
    			+ "300ml thickened cream\r\n"
    			+ "METHOD\r\n"
    			+ "Step 1\r\n"
    			+ "Cook the pasta in a saucepan of boiling water following packet directions or until al dente. Drain well, reserving ¼ cup (60ml) cooking liquid.\r\n"
    			+ "Step 2\r\n"
    			+ "Meanwhile, heat the oil in a large frying pan over medium heat. Add the tomatoes and cook, turning, for 4 mins or until the tomatoes begin to collapse. Transfer to a plate and cover to keep warm.\r\n"
    			+ "Step 3\r\n"
    			+ "Add zucchini, mushroom and garlic to pan. Season. Cook, stirring, for 4 mins or until vegetables begin to soften.\r\n"
    			+ "Step 4\r\n"
    			+ "Add the pasta, reserved cooking liquid, cream, chilli, if using, and tuna in sauce to the zucchini mixture. Cook, tossing, for 1 min or until heated through. Divide the pasta mixture among serving plates. Top with the tomatoes and sprinkle with parmesan.\r\n"
    			+ "");
    	break;
    case 31:
    	System.out.println("INGREDIENTS\r\n"
    			+ "1 large fennel bulb, trimmed, core removed\r\n"
    			+ "3 limes\r\n"
    			+ "2 green shallots, trimmed\r\n"
    			+ "3 large ripe avocados\r\n"
    			+ "250g baby cucumbers, peeled into ribbons\r\n"
    			+ "200g (1 bunch) radishes, trimmed, washed, thinly sliced\r\n"
    			+ "METHOD\r\n"
    			+ "Step 1\r\n"
    			+ "Use a mandoline to very thinly slice the fennel lengthways. Place in a large bowl with the juice of 1 lime. Add a large pinch of salt, toss to combine and set aside to pickle.\r\n"
    			+ "Step 2\r\n"
    			+ "Cut shallots into 8cm lengths and thinly slice lengthways. Place in a bowl of iced water for 2-3 minutes or until lightly curled. Drain well. Roughly mash the avocados in a bowl. Add the juice from the remaining limes, season and stir to combine.\r\n"
    			+ "Step 3\r\n"
    			+ "Drain fennel. Arrange avocado in a heaped circle around the edge of a large plate. Arrange pickled fennel, cucumber, radish, shallot and salmon over the top. Drizzle with oil and season with pepper. Dollop on crème fraîche and salmon roe. Scatter with the dill and micro herbs. Serve immediately with crackers or bread, if you like.\r\n"
    			+ "");
    	break;
    case 32:
    	System.out.println("INGREDIENTS\r\n"
    			+ "2 Red Royale or Royal Blue potatoes, thinly sliced\r\n"
    			+ "1 leek, pale section only, thickly sliced\r\n"
    			+ "1/3 cup dill sprigs\r\n"
    			+ "185g Coles Tasmanian Hot Smoked Salmon Pepper Fillets, coarsely flaked\r\n"
    			+ "METHOD\r\n"
    			+ "Step 1\r\n"
    			+ "Preheat grill on medium. Spray a 20cm (base measurement) ovenproof non-stick frying pan with olive oil spray. Place over medium heat. Add half the potato. Cook for 1 min each side or until light golden and tender. Transfer to a plate. Repeat with remaining potato.\r\n"
    			+ "Step 2\r\n"
    			+ "Add the leek to the pan and cook, stirring, for 5 mins or until leek softens. Transfer to a medium bowl.\r\n"
    			+ "Step 3\r\n"
    			+ "Coarsely chop half the dill sprigs. Spray the pan with olive oil spray. Arrange the potato, leek and salmon over the base of the pan. Whisk the egg and chopped dill in a jug. Season. Pour the egg mixture over the salmon mixture in the pan. Place pan over medium-low heat and cook for 5 mins or until egg mixture is almost set.\r\n"
    			+ "Step 4\r\n"
    			+ "Cook under grill for 5 mins or until golden and cooked through.\r\n"
    			+ "Step 5\r\n"
    			+ "Set the frittata aside in the pan for 2 mins. Cut into wedges. Sprinkle with the remaining dill to serve.\r\n"
    			+ "");
    	break;
    case 33:
    	System.out.println("INGREDIENTS\r\n"
    			+ "250g Coles Australian Pork Mince\r\n"
    			+ "1 cup finely shredded wombok (Chinese cabbage)\r\n"
    			+ "1 garlic clove, finely chopped\r\n"
    			+ "3cm-piece ginger, finely grated\r\n"
    			+ "2 tbs oyster sauce\r\n"
    			+ "METHOD\r\n"
    			+ "Step 1\r\n"
    			+ "Combine the mince, wombok, garlic, grated ginger, oyster sauce and two-thirds of the spring onion in a bowl. Season. Place the wonton wrappers on a clean work surface. Place 11/2 tsp of the mince mixture in centre of each wrapper. Brush edges with a little water. Bring corners together to enclose the filling and pinch the centres to seal.\r\n"
    			+ "Step 2\r\n"
    			+ "Heat 1 tsp oil in a frying pan over high heat until just smoking. Remove from heat. Arrange half the dumplings over the base of pan. Cook over medium heat for 2 mins or until bases are golden brown. Pour over half the stock. Cover. Cook for 2-3 mins or until the dumplings are cooked through. Repeat with 1 tsp oil and remaining dumplings and stock.\r\n"
    			+ "Step 3\r\n"
    			+ "Combine the ginger matchsticks, soy sauce, vinegar, chilli sauce, if using, sugar, remaining spring onion and remaining oil in a small bowl. Serve with dumplings.\r\n"
    			+ "");
    	break;
    case 34:
    	System.out.println("INGREDIENTS\r\n"
    			+ "500g extra lean pork mince\r\n"
    			+ "2 teaspoons Greek seasoning\r\n"
    			+ "2 cloves garlic, crushed\r\n"
    			+ "2 teaspoon dried oregano\r\n"
    			+ "2 spring onions, finely chopped\r\n"
    			+ "1 lemon, rind finely grated\r\n"
    			+ "METHOD\r\n"
    			+ "Step 1\r\n"
    			+ "Preheat oven to 220C/200C fan-forced. Line a large baking tray with non-stick baking paper. Combine pork mince, seasoning, garlic, oregano, spring onions, lemon and parmesan in a large bowl. Season with salt and pepper, mix well.\r\n"
    			+ "Step 2\r\n"
    			+ "Roll heaped tablespoons of mixture into walnut-sized balls. Lightly coat balls in flour, shaking off excess. Place egg in a shallow bowl with 1 tablespoon water and whisk. Place breadcrumbs on a tray. Dip balls in egg and then roll in breadcrumbs, pressing to coat. Place balls on tray and repeat.\r\n"
    			+ "Step 3\r\n"
    			+ "Spray balls liberally with oil spray. Bake for 25-30 minutes or until crisp and golden. Serve plain or with tomato chutney and mustard, if using.\r\n"
    			+ "\r\n"
    			+ "");
    	break;	
    case 35:
    	System.out.println("INGREDIENTS\r\n"
    			+ "12 slices Coles Bakery High Fibre Low GI White Sandwich Bread*, crusts removed\r\n"
    			+ "100g zucchini, coarsely grated \r\n"
    			+ "1/4 cup (30g) coarsely grated tasty cheddar\r\n"
    			+ "METHOD\r\n"
    			+ "Step 1\r\n"
    			+ "Preheat oven to 180°C. Grease 6 holes of a 1/3-cup (80ml) muffin pan. Place 1 slice of bread on a clean work surface. Arrange another slice of bread on top at a 45-degree angle. Use a rolling pin to roll out bread slices until 5mm thick. Repeat with remaining bread slices. Line the prepared holes with bread, pressing down firmly. Spray with olive oil spray. Bake for 15 mins or until just golden.\r\n"
    			+ "Step 2\r\n"
    			+ "Combine zucchini, cheddar, bacon and chives in a bowl. Divide evenly among the bread cases. Whisk the egg and milk in a jug and pour evenly over the zucchini mixture. Season. Bake for 20-25 mins or until the egg mixture is light golden and just set. Cool slightly. Serve warm or at room temperature.\r\n"
    			+ "");	
    	break;
    case 36:
    	System.out.println("INGREDIENTS\r\n"
    			+ "170g butter, chopped\r\n"
    			+ "375g (21 ⁄2 cups) plain flour\r\n"
    			+ "2 teaspoons baking powder\r\n"
    			+ "1 teaspoon salt\r\n"
    			+ "250ml (1 cup) buttermilk\r\n"
    			+ "1 egg, lightly whisked\r\n"
    			+ "3 garlic cloves, very finely chopped\r\n"
    			+ "METHOD\r\n"
    			+ "Step 1\r\n"
    			+ "Lightly grease the bowl of a 5.5L slow cooker and line with baking paper. Place the butter in a microwave-safe jug. Microwave on High for 1 minute or until melted.\r\n"
    			+ "Step 2\r\n"
    			+ "Whisk together the flour, baking powder and salt in a bowl. Make a well in the centre. Add the buttermilk, egg and 125ml (1 ⁄2 cup) melted butter. Use a flat-bladed knife to mix until mixture comes together.\r\n"
    			+ "Step 3\r\n"
    			+ "Turn the dough onto a lightly floured surface. Knead for 30 seconds or until smooth. Divide into 8 pieces.\r\n"
    			+ "Step 4\r\n"
    			+ "Add garlic, parsley and basil to remaining melted butter. Place in a shallow bowl. Gently roll a piece of dough into a smooth ball and roll in the garlic mixture to coat. Transfer to prepared slow cooker. Repeat with remaining dough and garlic mixture\r\n"
    			+ "Step 5\r\n"
    			+ "Cover and cook on High for 2 hours or until the bread is cooked through. Sprinkle with the cheese, cover and cook for a further 30 minutes or until the cheese is bubbling. Serve sprinkled with extra basil leaves.");		
    	break;
    case 37:
    	System.out.println("Ingredients\r\n"
    			+ "Serving\r\n"
    			+ "4\r\n"
    			+ "Original recipe yields 4 servings\r\n"
    			+ "Ingredient Checklist\r\n"
    			+ "¼ cup mayonnaise\r\n"
    			+ "3 cloves garlic, minced\r\n"
    			+ "1 tablespoon lemon juice\r\n"
    			+ "⅛ cup olive oil\r\n"
    			+ "1 cup sliced red bell peppers\r\n"
    			+ "2 (4-x6-inch) focaccia bread pieces, split horizontally\r\n"
    			+ "½ cup crumbled feta cheese\r\n"
    			+ "DirectionsInstructions Checklist\r\n"
    			+ "Step 1\r\n"
    			+ "In a bowl, mix the mayonnaise, minced garlic, and lemon juice. Set aside in the refrigerator.\r\n"
    			+ "\r\n"
    			+ "Step 2\r\n"
    			+ "Preheat the grill for high heat.\r\n"
    			+ "\r\n"
    			+ "Step 3\r\n"
    			+ "Brush vegetables with olive oil on each side. Brush grate with oil. Place bell peppers and zucchini closest to the middle of the grill, and set onion and squash pieces around them. Cook for about 3 minutes, turn, and cook for another 3 minutes. The peppers may take a bit longer. Remove from grill, and set aside.\r\n"
    			+ "\r\n"
    			+ "Step 4\r\n"
    			+ "Spread some of the mayonnaise mixture on the cut sides of the bread, and sprinkle each one with feta cheese. Place on the grill cheese side up, and cover with lid for 2 to 3 minutes. This will warm the bread, and slightly melt the cheese. Watch carefully so the bottoms don't burn. Remove from grill, and layer with the vegetables. Enjoy as open faced grilled sandwiches.");		
    	break;
    case 38:
    	System.out.println("INGREDIENTS\r\n"
    			+ "1 tablespoon extra virgin olive oil\r\n"
    			+ "1 Packed Soup \r\n"
    			+ "1 large brown onion, finely chopped\r\n"
    			+ "1 lemon\r\n"
    			+ "Directions\r\n"
    			+ "Stir chickpeas and beans into soup. Stand, covered, for 5 minutes or until warmed through. Season with salt and pepper. Ladle among bowls. Top with coriander and yoghurt. Serve with lemon wedges.");		
    	break;
    case 39:
    	System.out.println("A refreshing and chilled cold drink served in a glass to make your day a little better.");		
    	break;
    case 40:
    	System.out.println("Ingredients\r\n"
    			+ " 1 mug\r\n"
    			+ "Milk (1 mug)\r\n"
    			+ "Sugar (1 tbsp)\r\n"
    			+ "Nescafe Gold or any Arabica powder (1 tbsp)\r\n"
    			+ "\r\n"
    			+ "Steps\r\n"
    			+ "Arrange ingredients.\r\n"
    			+ "Boil milk in pot.\r\n"
    			+ "Add sugar and mix well.\r\n"
    			+ "In 1/2 cup milk add coffee powder and mix well.\r\n"
    			+ "Now pour the mixture in milk and stir well. Cook coffee on medium to high flame until frothy.\r\n"
    			+ "Pour in mug serve hot. Enjoy");	
    	break;
    case 41:
    	System.out.println("Ingredients\r\n"
    			+ "Milk (1 mug)\r\n"
    			+ "Sugar (1 tbsp)\r\n"
    			+ "Robusta powder (1 tbsp)\r\n"
    			+ "\r\n"
    			+ "Steps\r\n"
    			+ "Arrange ingredients.\r\n"
    			+ "Boil milk in pot.\r\n"
    			+ "Add sugar and mix well.\r\n"
    			+ "In 1/2 cup milk add coffee powder and mix well.\r\n"
    			+ "Now pour the mixture in milk and stir well. Cook coffee on medium to high flame until frothy.\r\n"
    			+ "Pour in mug serve hot. Enjoy");
    	break;
    case 42:
    	System.out.println("INGREDIENTS\r\n"
    			+ "2 cup milk \r\n"
    			+ "1 ginger\r\n"
    			+ "2 tablespoon Sugar\r\n"
    			+ "1 spoon Tea leaves\r\n"
    			+ "Directions\r\n"
    			+ "Put the tea leaves, milk and sugar in a mug of boiling water. Stand for 3 mins. Serve with a dash of milk.");
    	break;
    	default:
    		System.out.println("Not a part of Menu");
    
    }
    System.out.println("\n-----------------------------------------------------------------\n");
}

}



class date extends timed
{
private int d1,m1,y1,d2,m2,y2;
private boolean b1,b2;
Scanner z=new Scanner(System.in);
public void start_d()
{
d1=z.nextInt();
m1=z.nextInt();
y1=z.nextInt();
date ob=new date();
b1=ob.correctdate(d1,m1,y1);
}

public void end_d()
{
	Date d=new Date();  
    String s=d.toString();
    int m=0;
    String[] ar = s.split(" ",6); 
    if(ar[1].equals("Jan"))
    	m=1;
    if(ar[1].equals("Feb"))
    	m=2;
    if(ar[1].equals("Mar"))
    	m=3;
    if(ar[1].equals("Apr"))
    	m=4;
    if(ar[1].equals("May"))
    	m=5;
    if(ar[1].equals("Jun"))
    	m=6;
    if(ar[1].equals("Jul"))
    	m=7;
    if(ar[1].equals("Aug"))
    	m=8;
    if(ar[1].equals("Sep"))
    	m=9;
    if(ar[1].equals("Oct"))
    	m=10;
    if(ar[1].equals("Nov"))
    	m=11;
    if(ar[1].equals("Dec"))
    	m=12;
d2=Integer.parseInt(ar[2]);
m2=m;
y2=Integer.parseInt(ar[5]);
date ob=new date();
System.out.println("Date Today \"in DD MM YYYY\" is ::");
System.out.println(ar[2]+" "+m+" "+ar[5]);
b2=ob.correctdate(d2,m2,y2);
}

public int diff_d()
{
date ob=new date();
int r1=0,r2=0;
if(b1 && b2)
{
r1=ob.func(d1,m1,y1);
r2=ob.func(d2,m2,y2);
if(r1>=0 && r2>=0)
{
if((r2-r1)>=0)
return r2-r1;
else
{
System.out.println("You Are Living in a Parallel Universe with Time Moving Backwards : > ");
return -1;
}
}
else
{
System.out.println("You Are Living in a Parallel Universe with an bygone Calender : > ");
return -1;
}
}
else
{
System.out.println("You Are Living in a Parallel Universe with an Different span of time intervals: > ");
return -1;
}
}

public boolean correctdate(int d,int m,int y)
{
int j=m;
boolean b=false;
if(j==1||j==3||j==5||j==7||j==8||j==10||j==12)
{
if(d<=31)
b=true;
}
if(j==4||j==6||j==9||j==11)
{
if(d<=30)
b=true; 
}
if(j==2)
{
if(y%4==0 && d<=29)
b=true;
if(y%4!=0 && d<=28)
b=true;
if(y%400==0 && d>=29)
b=false;
}
return b;
}

public int func(int d,int m,int y)
{
int i,j,l=0,o=0,m1=m;
if(y<2020)
{
return -1;
} 
for(i=2020;i<=y;i++)
{
if(i!=y)
m1=13;
else
m1=m;
for(j=1;j<m1;j++)
{
if(j==1||j==3||j==5||j==7||j==8||j==10||j==12)
o=31;
if(j==4||j==6||j==9||j==11)
o=30;
if(j==2)
{
if(i%4==0)
o=29;
else
o=28;
}
l=l+o;
}
}
return l+d;
}
}


public class a
{
public static void main(String as[]) 
{
Scanner z=new Scanner(System.in);
date ob=new date();
items_class ob1=new items_class();
Date d=new Date();  
System.out.println(" --------------------------COOKit!-------------------------");
System.out.println(" 	  TODAY : "+d.toString()+"\n");
int sign;
while(true)
{
	System.out.println(" ENTER");
	System.out.println("   1. SIGN UP ::New Customer");//new coutomer
	System.out.println("   2. LOG IN  ::Existing Customer");//already existing
	System.out.println("   3. EXIT    ::end the process");//already existing
	sign=z.nextInt();
	if(sign==1)
	{
		System.out.println(" ---------------------SIGN UP-----------------------\n");
	    try {
	        FileWriter writer = new FileWriter("user.txt", true);
	        BufferedWriter bufferedWriter = new BufferedWriter(writer);
	        FileWriter writer1 = new FileWriter("info.txt", true);
	        BufferedWriter bufferedWriter1 = new BufferedWriter(writer1);
	        FileWriter writer2 = new FileWriter("pass.txt", true);
	        BufferedWriter bufferedWriter2 = new BufferedWriter(writer2);
	        System.out.println("Enter the details below to make a profile");
	        System.out.println("Enter Username for your profile");
	        String users=z.next();
	        System.out.println("Enter your Age");
	        String ages=z.next();
	        System.out.println("Enter your Email address");
	        String mails=z.next();
	        String pass="";
	        while(true)
	        {
	        System.out.println("Enter a Password");
	        pass=z.next();
	        System.out.println("Enter a Confirm Password");
	        String passc=z.next();
	        if(pass.equals(passc))
	        	break;	
	        else
	        	System.out.println("Password and Confirm Password should be same!!");	
	        }
	        
	        bufferedWriter1.write(users+" ");
	        bufferedWriter1.write(ages+" ");
	        bufferedWriter1.write(mails+" ");
	        bufferedWriter1.write(pass);
	        bufferedWriter1.newLine();
	        bufferedWriter.write(users);
	        bufferedWriter.write(" ");
	        bufferedWriter2.write(pass+" ");
            sign=2;
         /**   FileWriter fwOb = new FileWriter("user.txt", false); 
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();
            FileWriter fwOb1 = new FileWriter("pass.txt", false); 
            PrintWriter pwOb1 = new PrintWriter(fwOb1, false);
            pwOb1.flush();
            pwOb1.close();
            fwOb1.close();
       */
	        bufferedWriter.close();
	        bufferedWriter1.close();
	        bufferedWriter2.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	    if(sign==2)
	    { System.out.println("---------------------------LOG IN-----------------------\n");
	    	System.out.print("Username::");
	        String user=z.next();
	        System.out.print("Password::");
	        String pass=z.next();
	        System.out.println();
	        int character , character1;
	           
	        String s1="",s2="";
	    try {
	        FileReader reader = new FileReader("user.txt");
	        while ((character = reader.read()) != -1) 
	        {
	            s1=s1+((char)character);
	        }
	        reader.close();
	    } 
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
	    try {
	        FileReader reader2 = new FileReader("pass.txt");
	        while ((character1 = reader2.read()) != -1) {
	            s2=s2+((char)character1);
	        } 
	        reader2.close();
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }
        String[] words=s1.split(" ");
        String[] words2=s2.split(" ");
        int i4=-1,t=0;
        for(String w:words)
        {
        	i4++;
        	if(w.equals(user))
        	{
        	t=1;
        	break;	
        	}  
        } 
        if(t==1)
        {
        if(words2[i4].equals(pass))
        {
        	System.out.print("Checking ");
    		ob1.wait(500);
    		System.out.print(".");
    		ob1.wait(500);
    		System.out.print("..");
    		ob1.wait(200);
    		System.out.print(".");
    		ob1.wait(100);
    		System.out.print(".");
    		ob1.wait(100);
    		System.out.println(".\n");
        System.out.println(" --------------------LOGGED IN-------------------------\n");
        int ch=0;
        while(true)
        {
        	System.out.println("------Enter the process number you want execute-------\n");
        	System.out.println("1. STORE   ::To select the items in your fridge from cart");//to store the items in the fridge
        	System.out.println("2. STOVE   ::To get a recipe from ingredients from the fridge");//to make a dish and get its recipe
        	System.out.println("3. SAVE    ::Tricks and Tips to make items last longer");//tricks to make items stay in good condition for longer
        	System.out.println("4. SEPRATE ::To remove the items from your fridge");
        	System.out.println("5. SHOW    ::To display all the items in your fridge");
        	System.out.println("6. LOG OUT ::log out of current account");
        	int x=z.nextInt();
        	
        	
        	if(x==1)
        	{
        		int r3=0;
        		
        		aa:while(true)
        		{
        			if(ch==0)
        		{
        			System.out.println("Enter the Date of Purchase of Food Items \"In DD MM YYYY\" ");
            		ob.start_d();
            		ob.end_d();
        		}
        		
        		r3=ob.diff_d();
        		if(r3!=-1)
        		break aa;
        		else
        		System.out.println("Please enter a Valid Date");
        		}
        		ch++;
        		System.out.println("( : Please, Enter the items from the list :)");
        		ob1.display();
        		ob1.ingredients();
        		ob1.days_left(r3);
        		ob1.days_of_selected();
        	}
        	if(x==2)
        	{ 
        		if(ch==0)
        		{
        		System.out.println("First Enter the items in fridge then you can get a recipe");
        		
        		}
        		else
        		{
        		ob1.selection();
        		System.out.print("Fecthing Data");
        		ob1.wait(500);
        		System.out.print(" .");
        		ob1.wait(500);
        		System.out.print(".");
        		ob1.wait(400);
        		System.out.print(".");
        		ob1.wait(400);
        		System.out.print(".");
        		ob1.wait(200);
        		System.out.println(".\n");
        		int r2=ob1.dish();
        		if(r2==1)
        		ob1.selectdish();
        		else
        		System.out.println("Enter more ingredients");	
        			
        	}
        	}
        	if(x==3)
        	{
        		System.out.println("---------------------The List---------------------");	
        	ob1.display();
        	acc:while(true)
        	{
        	int safe=ob1.safeing();
        	if(safe==-1)
        		System.out.println("Wrong Ingredient!!");	
        	else
        	{
        		ob1.safetip(safe+1);
        		System.out.println("Enter \"Yes\"/\"Y\"/\"1\" to know Tips about other Ingredients \n\"No\"/N\"/\"0\" to Skip this Step");
        		String tips=z.next();
        		if(tips.equalsIgnoreCase("Yes") ||tips.equalsIgnoreCase("Y") ||tips.equals("1"))	
        		System.out.print("Re");
        		else
                   if(tips.equalsIgnoreCase("no") || tips.equalsIgnoreCase("n") ||tips.equals("0"))
                   break acc;
        	}
        	}
        	}
        	if(x==4)
        	{
        		System.out.println(" ----------Ingredients currently in fridge--------\n");
        		ob1.remdisplay() ;
        		System.out.println(" -------Enter Ingredients you want to remove--------");
        		ob1.remingredients();
        	}
        	if(x==5)
        	{
        		int x5=ob1.noofin();
        		if(x5>0)
        		{
        		System.out.println("------------------Ingredients-----------------------");	
        		ob1.remdisplay2();
        		}
        		else
        			System.out.println("No Ingredients to display");
        	}
        	if(x==6)
        		break;
        	System.out.println();
        	
        }
        }
        else
        	System.out.println("Incorrect Password!!!\n");
        }
        else
        	System.out.println("Incorrect Username or Password!!!!\n");
	    
	    }
	    if(sign==3)
	    break;
	
}
System.out.println("Thank You for using this project-----------------\nMade by:\nAditya Singh©\nDeepanshu Singh\nSidharth Saini\nEkansh Verma");
z.close();
}
}
