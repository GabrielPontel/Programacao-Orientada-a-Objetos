package modelo;
public class Catraca {
    private static int valor = 0;
    static public int getvalor()
    {
        Catraca.valor++;
        return Catraca.valor;
    }
}
