package library.model;

import library.exception.PublicationAlreadyExistsException;
import library.exception.UserAlreadyExistsException;
import library.model.Publication;
import library.model.Book;
import library.model.Magazine;

import java.io.Serializable;
import java.util.*;


public class Library implements Serializable {

    private Map<String, Publication> publications = new HashMap<>();

    private Map<String, LibraryUser> users = new HashMap<>();

    public Map<String, Publication> getPublications(){
        return publications;
    }

    public Map<String,LibraryUser> getUsers(){
        return users;

    }

    public void addUser(LibraryUser user){
        if(users.containsKey(user.getPesel()))
            throw new UserAlreadyExistsException("Użytkownik ze wskazanym pesel juz istnieje" + user.getPesel());
        users.put(user.getPesel(),user);

    }

    public void addPublication(Publication publication){
        if(publications.containsKey(publication.getTitle()))
            throw new PublicationAlreadyExistsException("Publikajca o takim tytule już istnieje " + publication.getTitle());
        publications.put(publication.getTitle(),publication);
    }

    public boolean removePublication(Publication publication){
        if(publications.containsValue(publication)){
            publications.remove(publication.getTitle());
            return true;
        }else {
            return false;
        }
    }

    public Collection<Publication> getSortedPublications(Comparator<Publication>comparator){
        ArrayList<Publication> list = new ArrayList<>(this.publications.values());
        list.sort(comparator);
        return list;
    }

    public Collection<LibraryUser> getSortedUsers(Comparator<LibraryUser> comparator) {
        ArrayList<LibraryUser> list = new ArrayList<>(this.users.values());
        list.sort(comparator);
        return list;
    }

/*
    public boolean removePublication(Publication pub){
        final int notFound = -1;
        int found = notFound;
        int i = 0;
        while (i< publicationsNumber && found == notFound){
            if(pub.equals(publications[i])){
                found = i;
            }else {
                i++;
            }
        }
        if (found!=notFound){
            System.arraycopy(publications,found +1 ,publications, found,
                    publications.length - found - 1);
            // publication- kopiujemy z tej tablicy elemtny,
            // found +1 - zaczynajac od indeksu wiekszego o 1 od indeksu pod ktorym jest zapisany obiekt ktory usuwamy
            // publication - kopiujemy do talibcy tej
            // found - na miejsce rozpoczynajac od indeksu pod ktorym jest zapisany obiekt do usuniecia
            // publications.length - kopiujemy tyle obiektow ktore wynikaja z roznicy dlugosci tablicy i indeksu ktory znalezxlismy

            publicationsNumber--;
            publications[publicationsNumber] = null;

        }
        return found != notFound;
    }*/

}

