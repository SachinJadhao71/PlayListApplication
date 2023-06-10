import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Album album1 = new Album("Dorrie","atif aslma");
        album1.addSongtotheAlbum("Bewajah",4.1);
        album1.addSongtotheAlbum("tera rasta",5.2);
        album1.addSongtotheAlbum("gerua",3.2);
        album1.addSongtotheAlbum("ashique",5.5);
        album1.addSongtotheAlbum("hamari adhuri kahani",4.4);

        if(album1.findSong("tera mera ")){
            System.out.println("song is present in the album");
        }
        else{
            System.out.println("song is not present in the album");
        }

        if( album1.findSong("Bewajah")){
            System.out.println("song is present in the album");
        }
        else{
            System.out.println("song is not present in the album");
        }




//        create playlist
        LinkedList<Song> myPlayList = new LinkedList<>();

        album1.addSongToPlayListFromAlbum("Bewajah",myPlayList);
        album1.addSongToPlayListFromAlbum("ashique",myPlayList);
        album1.addSongToPlayListFromAlbum(2,myPlayList);
        album1.addSongToPlayListFromAlbum(7,myPlayList);
        album1.addSongToPlayListFromAlbum("dhakad",myPlayList);

        play(myPlayList);

    }
    public static void play(LinkedList<Song> myPlayList){

        ListIterator<Song> itr = myPlayList.listIterator();

//        check weather playlist is empty or not
        if(!itr.hasNext()){
            System.out.println("Ohh... Your Playlist is currently Empty");
            return;
        }

        System.out.println("Now Playing :");
        System.out.println(itr.next());

        printmenu();

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("please select your option");
            int option  = sc.nextInt();

            switch(option){
                case 1 :
                    if(itr.hasNext()){
                        System.out.println("Now Playing :");
                        System.out.println(itr.next());
                    }
                    else{
                        System.out.println("No next song is present");
                    }
                    break;
                case 2:
                    if(itr.hasPrevious()){
                        System.out.println("Now Playing :");
                        System.out.println(itr.previous());
                    }
                    else{
                        System.out.println("You are at the starting position");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    PrintSongs(myPlayList);
                    break;
                case 5:
                    break;
                case 6:
                    printmenu();
                    break;
                case 7:
                    exit(0);
            }
        }

    }
    public static void PrintSongs(LinkedList<Song> myplaylsit){
        for(Song s : myplaylsit){
            System.out.println(s);
        }
        return;
    }
    public static void printmenu(){

        System.out.println("1. Play next song");
        System.out.println("2. Play previous song");
        System.out.println("3. Repeat the current song");
        System.out.println("4. Show all songs in playlist");
        System.out.println("5. delete the current song");
        System.out.println("6. Show the menu again");
        System.out.println("7. Exit");
    }
}