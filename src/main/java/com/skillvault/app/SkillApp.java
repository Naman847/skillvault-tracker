package com.skillvault.app;

import com.skillvault.dao.SkillDAO;
import com.skillvault.model.Skill;

import java.util.List;
import java.util.Scanner;

public class SkillApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SkillDAO service = new SkillDAO();

        while (true) {
            System.out.println("\n--- SkillVault Menu ---");
            System.out.println("1. Add Skill");
            System.out.println("2. View All Skills");
            System.out.println("3. View Skill by ID");
            System.out.println("4. Update Skill");
            System.out.println("5. Delete Skill");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Skill ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Skill Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Skill Category: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter Difficulty (1 to 5): ");
                    int difficulty = scanner.nextInt();

                    System.out.print("Enter Mastery Level (1 to 100): ");
                    int masteryLevel = scanner.nextInt();

                    Skill newSkill = new Skill(id, name, category, difficulty, masteryLevel);
                    boolean inserted = service.insertSkill(newSkill);

                    if (inserted) {
                        System.out.println("Skill inserted successfully.");
                    } else {
                        System.out.println("Failed to insert skill.");
                    }
                    break;

                case 2:
                    List<Skill> skills = service.viewAllSkills();
                    if (skills.isEmpty()) {
                        System.out.println("No skills found.");
                    } else {
                        for (Skill s : skills) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Skill ID to view: ");
                    int viewId = scanner.nextInt();
                    Skill skillById = service.getSkillById(viewId);
                    if (skillById != null) {
                        System.out.println(skillById);
                    } else {
                        System.out.println("Skill not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Skill ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Category: ");
                    String newCategory = scanner.nextLine();

                    System.out.print("Enter New Difficulty: ");
                    int newDifficulty = scanner.nextInt();

                    System.out.print("Enter New Mastery Level: ");
                    int newMastery = scanner.nextInt();

                    Skill updatedSkill = new Skill(updateId, newName, newCategory, newDifficulty, newMastery);
                    boolean updated = service.updateSkill(updatedSkill);
                    if (updated) {
                        System.out.println("Skill updated successfully.");
                    } else {
                        System.out.println("Failed to update skill.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Skill ID to delete: ");
                    int deleteId = scanner.nextInt();
                    boolean deleted = service.deleteSkill(deleteId);
                    if (deleted) {
                        System.out.println("Skill deleted successfully.");
                    } else {
                        System.out.println("Failed to delete skill.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting SkillVault. Goodbye.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
