Java - Date/SimpleDateFormat/Calendar/TimeZone

System.currentTimeMillis() - Metodo estatico que retorna a data e o tempo como milissegundo desde 01/01/1970.
The granularity of the System.currentTimeMillis() method is larger than 1 millisecond. If you call this method repeatedly, you will see that you get the same value back for a while, then it all of a sudden jumps by 10-20-30 milliseconds or more. It is not the worlds most precise or fine grained timer.


java.util.Date  - Classe concreta Data, cotem a data e o tempo.
java.sql.Date -  Eh utilizado com a API JDBC, extende o java.util.Date, esse Date apenas segura a Data, as horas ele descarta.
java.sql.TimeStamp - Eh utilizado com a API JDBC, extende o java.util.Date, esse date cria data com o tempo, mas a diferenca dele com o Date eh que ele consegue segurar o nanosegundos(getNanos());



Date

Date minhaData = new Date();
1-  System.out.print(minhaData)  - Tue Oct 27 20:22:28 BRST 2015
2-  System.out.print(minhaData.getTime()) - 1445988860995




SimpleDateFormat 

A classe SimpleDateFormat eh usada tanto para parsear quanto para formatar datas.

//Data Para String
Date minhaData = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
String dataParaString = sdf.format(minhaData);
System.out.println(dataParaString);   - 27/10/2015

//String para Data
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Date date = sdf.parse("27/10/2015");
System.out.print(date); - Tue Oct 27 00:00:00 BRST 2015


Alguns Formatos :
dd-MM-yy	31-01-12
dd-MM-yyyy	31-01-2012
MM-dd-yyyy	01-31-2012
yyyy-MM-dd	2012-01-31
yyyy-MM-dd HH:mm:ss	2012-01-31 23:59:59
EEEE MMMM dd/MM/yyyy Terça-feira Outubro 27/10/2015

Significados :

G	Era designator (before christ, after christ)
y	Year (e.g. 12 or 2012). Use either yy or yyyy.
M	Month in year. Number of M's determine length of format (e.g. MM, MMM or MMMMM)
d	Day in month. Number of d's determine length of format (e.g. d or dd)
h	Hour of day, 1-12 (AM / PM) (normally hh)
H	Hour of day, 0-23 (normally HH)
m	Minute in hour, 0-59 (normally mm)
s	Second in minute, 0-59 (normally ss)
S	Millisecond in second, 0-999 (normally SSS)
E	Day in week (e.g Monday, Tuesday etc.)
D	Day in year (1-366)
F	Day of week in month (e.g. 1st Thursday of December)
w	Week in year (1-53)
W	Week in month (0-5)
a	AM / PM marker
k	Hour in day (1-24, unlike HH's 0-23)
K	Hour in day, AM / PM (0-11)
z	Time Zone
'	Escape for text delimiter
'	Single quote



Calendar
A classe Calendar eh usada para datas e fazer calculos com o tempo, uma classe mais avancada caso seja necessario.
Ela eh abstrata,a razao disso eh que existe mais de um calendario no mundo.

Calendar calendar = new GregorianCalendar();

int year       = calendar.get(Calendar.YEAR);
int month      = calendar.get(Calendar.MONTH); 
int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); // Jan = 0, not 1
int dayOfWeek  = calendar.get(Calendar.DAY_OF_WEEK);
int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
int weekOfMonth= calendar.get(Calendar.WEEK_OF_MONTH);

int hour       = calendar.get(Calendar.HOUR);        // 12 hour clock
int hourOfDay  = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
int minute     = calendar.get(Calendar.MINUTE);
int second     = calendar.get(Calendar.SECOND);
int millisecond= calendar.get(Calendar.MILLISECOND);

Pitfalls do calendar
-Month nao vai do 1 ao 12, e sim do 0 ao 11.
-o dia vai do 1 ao 7, mas o primeiro dia eh Domingo.



