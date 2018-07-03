#java -jar proguard/proguard-base-6.0.2.jar @L01.2.pro

-injars       ./target/L01.2-obfuscation.jar
-outjars      ./target/L01.2-obfuscation-small-commandLine.jar

-printmapping pgmapout.map
-dontwarn

-keep public class ru.otus.l012.Main {public static void main(java.lang.String[]);}