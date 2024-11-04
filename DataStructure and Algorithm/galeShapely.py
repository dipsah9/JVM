def gale_shapley(students, families):
    # Number of students or families (assuming equal number)
    n = len(students)

    # Each student and family starts unengaged
    free_students = list(range(n))
    students_matched_to = [-1] * n  # -1 indicates not matched yet
    families_matched_to = [-1] * n

    # Reverse preference list for families for easy lookup or matching
    families_ranking = []
    for prefs in families:
        ranking = {family: rank for rank, family in enumerate(prefs)}
        families_ranking.append(ranking)

    # While there are free students who are not yet matched
    while free_students:
        student = free_students.pop(0)  # Take the first free student
        student_prefs = students[student]  # Get the preferences of the current student

        for family_name in student_prefs:
            # Convert family_name to an index
            family_index = int(family_name) - 1  # Assuming family names are '1', '2', '3', etc.
            current_match = families_matched_to[family_index]  # Check current match of the family

            if current_match == -1:
                # Family is free, just match them
                students_matched_to[student] = family_name
                families_matched_to[family_index] = student
                break
            else:
                # Family is already matched, check if they prefer the new student
                current_student_rank = families_ranking[family_index][current_match]
                new_student_rank = families_ranking[family_index][student]

                if new_student_rank < current_student_rank:
                    # Family prefers new student, so update the match
                    free_students.append(current_match)  # Make the current match free
                    students_matched_to[current_match] = -1  # Unmatch the current student

                    # Engage new student with this family
                    students_matched_to[student] = family_name
                    families_matched_to[family_index] = student
                    break

    return [(student, students_matched_to[student]) for student in range(n)]

# Example usage
students_preferences = [
    ['1', '2', '3'],  # Student 0 prefers Family 1, 2, 3
    ['2', '3', '1'],  # Student 1 prefers Family 2, 3, 1
    ['3', '1', '2'],   # Student 2 prefers Family 3, 1, 2
]

families_preferences = [
    ['A', 'B', 'C'],  # Family 1 prefers Student A, B, C
    ['C', 'A', 'B'],  # Family 2 prefers Student C, A, B
    ['B', 'C', 'A']   # Family 3 prefers Student B, C, A
]

stable_matching = gale_shapley(students_preferences, families_preferences)
print("Stable matching:", stable_matching)
