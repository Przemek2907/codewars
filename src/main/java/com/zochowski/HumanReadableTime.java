public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds / 60 % 60);
        int second = seconds % 60;

        String hourText = String.valueOf(hours).toCharArray().length == 2 ? String.valueOf(hours) : new StringBuilder().append("0" + hours).toString();
        String minutesText = String.valueOf(minutes).toCharArray().length == 2 ? String.valueOf(minutes) : new StringBuilder().append("0" + minutes).toString();
        String secondsText = String.valueOf(second).toCharArray().length == 2 ? String.valueOf(second) : new StringBuilder().append("0" + second).toString();

        return new StringBuilder().append(hourText).append(":").append(minutesText).append(":").append(secondsText).toString();
    }

    public static String makeReadableShortestSolution(int seconds) {
        return String.format("%02d:%02d:%02d", seconds / 3600, (seconds / 60) % 60, seconds % 60);
    }
}
