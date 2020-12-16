package Encapsulamento.ExemploControle;

public class Controle implements Controlador{
    private int volume;
    private boolean ligado;
    private boolean tocando;

    //metodos abstratos
    @Override
    public void ligar(){
        setLigado(true);
    }

    @Override
    public void desligar(){
        setLigado(false);
    }

    @Override
    public void abrirMenu(){
        System.out.println("---Menu Principal ---");
        System.out.println("Ligado ?"+this.getLigado());
        System.out.println("Volume:" +this.getVolume());
        for(int i=1; i<=getVolume();i+=10){
            System.out.print(" || ");
        };
    }

    @Override
    public void fecharMenu(){
        System.out.println("Fechando menu...");

    }
    @Override
    public void maisVolume(){
        if(getLigado() == true){
            setVolume(getVolume()+5);
        };
    }

    @Override
    public void menosVolume(){
        if(getLigado()){
            setVolume(getVolume()-5);
        }
    }

    @Override
    public void ligarMudo(){
        if( getLigado()  && ( getVolume() > 0) ) {
            setVolume(0);
        }
    }

    @Override
    public void desligarMudo(){
        if(getLigado()  && (getVolume() == 0)) {
            setVolume(50);
        };
        
    }

    @Override
    public void play(){
        if(getLigado() && !getTocando()){
            setTocando(true);
        }
    }

    @Override
    public void pause(){
        if(getLigado() && getLigado()){
            setTocando(false);
        }   
    }

    //metodos especiais
    public Controle(){
        setVolume(50);
        setLigado(false);
        setTocando(false);
    }
    private int getVolume() {
        return volume;
    }
    private void setVolume(int volume) {
        this.volume = volume;
    }
    private boolean getLigado() {
        return ligado;
    }
    private void setLigado(boolean ligado) {
        this.ligado = ligado;
    }
    private boolean getTocando() {
        return tocando;
    }   
    private void setTocando(boolean tocando) {
        this.tocando = tocando;
    }
 

}
