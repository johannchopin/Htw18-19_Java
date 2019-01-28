import java.util.Random;

/**
 * Useful to manipulate the LagerDialog
 *
 * @author  Alexandre Guidoux
 * @version 1.0
 */
public class Fabric
{
    private Queue q;
    Random randomThat = new Random();
    int dice; // Store a random number like a dice   

    /**
     * Create a full Lager with products
     */
    public Fabric()
    {
        int size, itemsInQueue;

        int queueType = randomThat.nextInt(2);
        if(queueType == 1){
            size = Helpers.max(randomThat.nextInt(strings.length), 1);
            q = new StringQueue(size);
        } else {
            size = Helpers.max(randomThat.nextInt(persons.length), 1);
            q = new PersonQueue(size);
        }

        itemsInQueue = Helpers.max(randomThat.nextInt(size), 1);

        System.out.println("\n////////// Log //////////\n" 
            + "Groesse des Queue: " + size + '\n');

        if (q instanceof StringQueue)
            StringGen(itemsInQueue);
        else if (q instanceof PersonQueue)
            PersonGen(itemsInQueue); 

        System.out.println("\nItems in Queue: " + itemsInQueue
            + "\n/////////////////");

        new QueueDialog(q).start();
    }

    private void StringGen(int nTimes){
        String currentStr;
        for(int i=0; i < nTimes; i++){
            dice = randomThat.nextInt(strings.length);
            try{
                currentStr = strings[dice];
                q.addLast(currentStr);
                System.out.println("Added : " + currentStr);
            } catch(Exception e){
                i--;
            }
        }
    }

    private void PersonGen(int nTimes){
        Person currentPerson;
        for(int i=0; i < nTimes; i++){
            dice = randomThat.nextInt(persons.length);
            try{
                currentPerson = persons[dice];
                q.addLast(currentPerson);
                System.out.println("Added : " + currentPerson);
            } catch(Exception e){
                System.out.println(e);
                i--;
            }
        }
    }

    private String[] strings = {
        "COME AT ME BRO",
        "Haters Gonna Hate",
        "'Dat Ass",
        "Shut Up and Take My Money!",
        "Bongo Cat",
        "You know you're in trouble when they call you by your full name",
        "Shut Up and Take My Money!",
        "Say hello to my little friend.",
        "May the force be with you.",
        "And his name is John Cena",        
    };

    private Person[] persons = {
        new Person("Henry", "Frankum"),
        new Person("Kenna", "Wadlow"),
        new Person("Ernie", "Crecelius"),
        new Person("Ramona", "Marcy"),
        new Person("Deja", "Jeans"),
        new Person("Larraine", "Cichon"),
        new Person("Bryce", "Pretty"),
        new Person("Jackqueline", "Dempster"),
        new Person("Willetta", "Dagenais"),
        new Person("Gregoria", "Nitta"),
        new Person("Melinda", "Torbert"),
        new Person("Jacquelin", "Christianson"),
        new Person("Karena", "Merrell"),
        new Person("Misty", "Cordon"),
        new Person("Sheilah", "Linley"),
        new Person("Jennifer", "Ferri"),
        new Person("Emmy", "Rape"),
        new Person("Fidel", "Talmage"),
        new Person("Isaura", "Struthers"),
        new Person("Kristi", "Yearwood"),
        new Person("Enedina", "Bigler"),
        new Person("Daren", "Crisp"),
        new Person("Burma", "Cliett"),
        new Person("Danika", "Hulings"),
        new Person("Francoise", "Caruso"),
        new Person("Adriene", "Linscott"),
        new Person("Hsiu", "Louder"),
        new Person("Nellie", "Liakos"),
        new Person("Grace", "Kamen"),
        new Person("Amira", "Tsuji"),
        new Person("Mitchel", "Bermeo"),
        new Person("Isidro", "Old"),
        new Person("Hope", "Kehr"),
        new Person("Lisa", "Sealy"),
        new Person("Reggie", "Stuart"),
        new Person("Ashlea", "Byington"),
        new Person("Terese", "Calvery"),
        new Person("Samatha", "Fountain"),
        new Person("Gwenda", "Cahoon"),
        new Person("Jerrell", "Shetley"),
        new Person("Kareem", "Frenkel"),
        new Person("Malcolm", "Jantzen"),
        new Person("Marylin", "Clauss"),
        new Person("Jennette", "Asher"),
        new Person("Lida", "Shkreli"),
        new Person("Lucienne", "Callaghan"),
        new Person("Olimpia", "Centers"),
        new Person("Babette", "Kimmer"),
        new Person("Johnathan", "Boedeker"),
        new Person("Nickolas", "Petrick")
};
}
