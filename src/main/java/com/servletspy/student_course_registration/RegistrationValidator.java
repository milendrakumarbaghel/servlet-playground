package com.servletspy.student_course_registration;

/**
 * Utility class containing validation helpers for the registration form.
 */
public final class RegistrationValidator {
    private RegistrationValidator() {}

    public static boolean isNotBlank(String s) {
        return s != null && !s.isBlank();
    }

    public static boolean isNameValid(String name) {
        return isNotBlank(name);
    }

    public static boolean isEmailValid(String email) {
        if (!isNotBlank(email)) return false;
        // simple email pattern (sufficient for demo). For production consider using a robust validator.
        return email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    }

    /**
     * Parses the age string and returns the integer if valid (>=18). Returns null when invalid.
     */
    public static Integer parseAndValidateAge(String ageStr) {
        if (ageStr == null || ageStr.isBlank()) return null;
        try {
            int age = Integer.parseInt(ageStr);
            return age >= 18 ? age : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static boolean isCourseValid(String course) {
        return isNotBlank(course);
    }

    public static boolean isBatchValid(String batch) {
        return isNotBlank(batch);
    }
}

