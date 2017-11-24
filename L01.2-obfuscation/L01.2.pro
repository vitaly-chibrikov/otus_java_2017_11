#java -jar proguard\proguard-base-5.3.1.jar @L01.2.pro

-injars       target/L01.2.jar
-outjars      target/L01.2-out.jar

-libraryjars  <java.home>/lib/rt.jar #contains all of the compiled class files for the base Java Runtime environment
-printmapping pgmapout.map
-dontwarn

-keep public class ru.otus.l0111.Main {public static void main(java.lang.String[]);}