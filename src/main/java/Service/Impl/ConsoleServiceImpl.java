package Service.Impl;

import Service.ConsoleService;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleServiceImpl implements ConsoleService {
    public static int choice = 0;
    public void GUI() throws IOException, JSONException, ParseException {
        CRUDServiceImpl crudService = new CRUDServiceImpl();
        SearchServiceImpl searchService = new SearchServiceImpl();
        while (choice != 5){
            System.out.println("Welcome to database\n" +
                    "1 -> Add data to database\n" +
                    "2 -> Update data to database\n" +
                    "3 -> Remove data from database\n" +
                    "4 -> Search for data\n" +
                    "5 -> Quit application\n");
            try {

                Scanner input = new Scanner(System.in);
                choice = input.nextInt();
            }catch (Exception e){
                System.out.println("Please enter digits between 1-5:\n");
            }

            switch (choice) {
                case 1:

                    System.out.println("Enter name: \n");
                    Scanner scannerName = new Scanner(System.in);
                    String name = scannerName.nextLine();
                    Pattern p = Pattern.compile("([a-zA-Z])");
                    Matcher m = p.matcher(name);
                    if(!m.find()){
                        System.out.println("ERROR!\nEnter your name properly:\n");
                        break;
                    }
                    System.out.println("Enter surname: \n");
                    Scanner scannerSurname = new Scanner(System.in);
                    String surname = scannerSurname.nextLine();
                    Pattern pSurname = Pattern.compile("([a-zA-Z])");
                    Matcher mSurname = pSurname.matcher(name);
                    if(!mSurname.find()){
                        System.out.println("ERROR!\nEnter your surname properly:\n");
                        break;
                    }
                    System.out.println("Enter father name: \n");
                    Scanner scannerFatherName = new Scanner(System.in);
                    String fatherName = scannerFatherName.nextLine();
                    Pattern pFather = Pattern.compile("([a-zA-Z])");
                    Matcher mFather = pFather.matcher(fatherName);
                    if(!mFather.find()){
                        System.out.println("ERROR!\nEnter your father name properly:\n");
                        break;
                    }
                    System.out.println("Enter email: \n");
                    Scanner scannerEmail = new Scanner(System.in);
                    String email = scannerEmail.nextLine();
                    Pattern pEmail = Pattern.compile("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$");
                    Matcher mEmail = pEmail.matcher(email);
                    if(!mEmail.find()){
                        System.out.println("ERROR!\nEnter your email properly:\n");
                        break;
                    }
                    System.out.println("Enter phone number: \n");
                    Scanner scannerPhoneNumber = new Scanner(System.in);
                    String phoneNumber = scannerPhoneNumber.nextLine();
                    Pattern pNumber = Pattern.compile("^\\+(1-9){11}");
                    Matcher mNumber = pNumber.matcher(phoneNumber);
                    if(!mNumber.find()){
                        System.out.println("ERROR!\nEnter your phone number properly:\n");
                        break;
                    }
                    crudService.addStudent(name,surname,fatherName,email,phoneNumber);
                    break;
                case 2:
                    System.out.println("What do you want to change:\n" +
                            "1 - name:\n" +
                            "2 - surname:\n" +
                            "3 - father name:\n");

                    Scanner updateChoice = new Scanner(System.in);
                    int scannedUpdateChoice = updateChoice.nextInt();
                    switch (scannedUpdateChoice) {
                        case 1:
                            System.out.println("Enter name: \n");
                            Scanner scannerOldName = new Scanner(System.in);
                            String oldName = scannerOldName.nextLine();
                            Pattern pOldName = Pattern.compile("([a-zA-Z])");
                            Matcher mOldName = pOldName.matcher(oldName);
                            if (!mOldName.find()) {
                                System.out.println("ERROR!\nEnter your name properly:\n");
                                break;
                            }
                            System.out.println("Enter name: \n");
                            Scanner scannerNewName = new Scanner(System.in);
                            String newName = scannerNewName.nextLine();
                            Pattern pNewName = Pattern.compile("([a-zA-Z])");
                            Matcher mNewName = pNewName.matcher(newName);
                            if (!mNewName.find()) {
                                System.out.println("ERROR!\nEnter your name properly:\n");
                                break;
                            }
                            crudService.updateStudentName(newName, oldName);
                        case 2:
                            System.out.println("Enter name: \n");
                            Scanner scannerOldSurname = new Scanner(System.in);
                            String oldSurname = scannerOldSurname.nextLine();
                            Pattern pOldSurname = Pattern.compile("([a-zA-Z])");
                            Matcher mOldSurname = pOldSurname.matcher(oldSurname);
                            if (!mOldSurname.find()) {
                                System.out.println("ERROR!\nEnter your surname properly:\n");
                                break;
                            }
                            System.out.println("Enter name: \n");
                            Scanner scannerNewSurname = new Scanner(System.in);
                            String newSurname = scannerNewSurname.nextLine();
                            Pattern pNewSurname = Pattern.compile("([a-zA-Z])");
                            Matcher mNewSurname = pNewSurname.matcher(newSurname);
                            if (!mNewSurname.find()) {
                                System.out.println("ERROR!\nEnter your surname properly:\n");
                                break;
                            }
                            crudService.updateStudentSurname(newSurname, oldSurname);
                        case 3:
                            System.out.println("Enter father name: \n");
                            Scanner scannerOldFatherName = new Scanner(System.in);
                            String oldFatherName = scannerOldFatherName.nextLine();
                            Pattern pOldFatherName = Pattern.compile("([a-zA-Z])");
                            Matcher mOldFatherName = pOldFatherName.matcher(oldFatherName);
                            if (!mOldFatherName.find()) {
                                System.out.println("ERROR!\nEnter your father name properly:\n");
                                break;
                            }
                            System.out.println("Enter father name: \n");
                            Scanner scannerNewFatherName = new Scanner(System.in);
                            String newFatherName = scannerNewFatherName.nextLine();
                            Pattern pNewFatherName = Pattern.compile("([a-zA-Z])");
                            Matcher mNewFatherName = pNewFatherName.matcher(newFatherName);
                            if (!mNewFatherName.find()) {
                                System.out.println("ERROR!\nEnter your father name properly:\n");
                                break;
                            }
                            crudService.updateStudentFatherName(newFatherName, oldFatherName);
                    }
                    break;
                case 3:
                    System.out.println("Enter name which you want to delete: \n");
                    Scanner scannerNameToDelete = new Scanner(System.in);
                    String nameToDelete = scannerNameToDelete.nextLine();
                    Pattern pNameDelete = Pattern.compile("([a-zA-Z])");
                    Matcher mNameDelete = pNameDelete.matcher(nameToDelete);
                    if(!mNameDelete.find()){
                        System.out.println("Error!\nEnter name to delete properly");
                        break;
                    }
                    crudService.delete(nameToDelete);
                    break;
                case 4:
                    System.out.println("How do you want to search:\n" +
                            "1 - With name:\n" +
                            "2 - With surname:\n" +
                            "3 - With father name:\n");
                    Scanner scannerSearchChoice = new Scanner(System.in);
                    int searchChoice = scannerSearchChoice.nextInt();
                    switch (searchChoice) {
                        case 1:
                            System.out.println("Enter name: ");
                            Scanner scannerSearchName = new Scanner(System.in);
                            String searchName = scannerSearchName.nextLine();
                            searchService.searchByName(searchName);
                        case 2:
                            System.out.println("Enter surname: \n");
                            Scanner scannerSearchSurname = new Scanner(System.in);
                            String searchSurname = scannerSearchSurname.nextLine();
                            searchService.searchBySurname(searchSurname);
                        case 3:
                            System.out.println("Enter father name: \n");
                            Scanner scannerSearchFatherName = new Scanner(System.in);
                            String searchFatherName = scannerSearchFatherName.nextLine();
                            searchService.searchByFatherName(searchFatherName);
                    }
                    break;
                case 5:
                    System.out.println("Quit......");
                    break;
                default:
                    System.out.println("Enter number between 1-5\n");
                    break;
            }
        }

    }
}
