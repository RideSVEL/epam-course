package ua.nure.vasilchenko.practice8;

import ua.nure.vasilchenko.practice8.db.DBExceptions;
import ua.nure.vasilchenko.practice8.db.DBManager;
import ua.nure.vasilchenko.practice8.db.entity.Team;
import ua.nure.vasilchenko.practice8.db.entity.User;

import java.sql.SQLException;
import java.util.List;

public class Demo {

    private static void printList(List<?> list) {
        System.out.println(list);
    }

    public static void main(String[] args) throws DBExceptions, SQLException {
        // users  ==> [ivanov]
        // teams ==> [teamA]

        DBManager dbManager = DBManager.getInstance();

        User user = User.createUser("user");
        Team teamA = Team.createTeam("A");
        Team teamB = Team.createTeam("B");
        Team teamC = Team.createTeam("C");
        Team teamD = Team.createTeam("D");

        dbManager.insertUser(user);
        dbManager.insertTeam(teamA);
        dbManager.insertTeam(teamB);
        dbManager.insertTeam(teamC);
        dbManager.insertTeam(teamD);

        dbManager.setTeamsForUser(user, teamA);

        dbManager.setTeamsForUser(user, teamB, teamC, teamD, teamA);

        System.out.println(teamA == dbManager.getUserTeams(user));

//        // Part 1
//        dbManager.insertUser(User.createUser("petrov"));
//        dbManager.insertUser(User.createUser("obama"));
//        printList(dbManager.findAllUsers());
//        // users  ==> [ivanov, petrov, obama]
//
//        System.out.println("===========================");
//
//        // Part 2
//        dbManager.insertTeam(Team.createTeam("teamB"));
//        dbManager.insertTeam(Team.createTeam("teamC"));
//
//        printList(dbManager.findAllTeams());
//        // teams ==> [teamA, teamB, teamC]
//
//        System.out.println("===========================");
//
//        // Part 3
//        User userPetrov = dbManager.getUser("petrov");
//        User userIvanov = dbManager.getUser("ivanov");
//        User userObama = dbManager.getUser("obama");
//
//        Team teamA = dbManager.getTeam("teamA");
//        Team teamB = dbManager.getTeam("teamB");
//        Team teamC = dbManager.getTeam("teamC");
//
//        // method setTeamsForUser must implement transaction!
//        dbManager.setTeamsForUser(userIvanov, teamA);
//        dbManager.setTeamsForUser(userPetrov, teamA, teamB);
//        dbManager.setTeamsForUser(userObama, teamA, teamB, teamC);
//
//        for (User user : dbManager.findAllUsers()) {
//            printList(dbManager.getUserTeams(user));
//            System.out.println("~~~~~");
//        }
//        // teamA
//        // teamA teamB
//        // teamA teamB teamC
//
//        System.out.println("===========================");
//
//        // Part 4
//
//        // on delete cascade!
//        dbManager.deleteTeam(teamA);
//
//        // Part 5
//        teamC.setName("teamX");
//        dbManager.updateTeam(teamC);
//        printList(dbManager.findAllTeams());
//        // teams ==> [teamB, teamX]

    }
}
