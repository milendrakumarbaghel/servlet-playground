package com.servletspy.student_course_registration;


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
        return email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    }

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

