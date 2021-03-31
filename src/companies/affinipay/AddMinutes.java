package companies.affinipay;


/**
 * The Class AddMinutes.
 *
 * @author Prathamesh Mantri
 * @version AffiniPay Interview Task
 * <p>
 * <p>
 * Though question clearly states that its an 12-hour clock and will have valid input. I still have created following exceptions.
 * A user could enter any invalid input or garbage value. A program should be capable enough to handle invalid and garbage input and should return proper response.
 * Below exception takes care of most of the invalid input cases.
 */

public class AddMinutes {


    public static void main(String[] args) {

        AddMinutes addMinutes = new AddMinutes();

        System.out.println(addMinutes.addMinutes("12:04 PM", 1445));
        System.out.println(addMinutes.addMinutes("11:00 PM", 1445));
        System.out.println(addMinutes.addMinutes("12:00 AM", 1440));
        System.out.println(addMinutes.addMinutes("12:00 PM", 1440));
        System.out.println(addMinutes.addMinutes("2:54 PM", 2000));
        System.out.println(addMinutes.addMinutes("5:40 PM", 110));
        System.out.println(addMinutes.addMinutes("11:40 AM", 200));
        System.out.println(addMinutes.addMinutes("12:18 PM", 10));
        System.out.println(addMinutes.addMinutes("11:25 PM", 720));
        System.out.println(addMinutes.addMinutes("12:25 PM", 720));
        System.out.println(addMinutes.addMinutes("1:25 PM", 720));
        System.out.println(addMinutes.addMinutes("11:25 AM", 720));
        System.out.println(addMinutes.addMinutes("12:25 AM", 720));
        System.out.println(addMinutes.addMinutes("1:25 AM", 720));
        System.out.println(addMinutes.addMinutes("11:25 PM", 1440));
        System.out.println(addMinutes.addMinutes("12:25 PM", 1440));
        System.out.println(addMinutes.addMinutes("1:25 PM", 1440));
        System.out.println(addMinutes.addMinutes("11:25 AM", 1440));
        System.out.println(addMinutes.addMinutes("12:25 AM", 1440));
        System.out.println(addMinutes.addMinutes("1:25 AM", 1440));
        System.out.println(addMinutes.addMinutes("12:04 AM", 1325));
        System.out.println(addMinutes.addMinutes("2:00 PM", 178));
        System.out.println(addMinutes.addMinutes("11:11 AM", 1450));
        System.out.println(addMinutes.addMinutes("12:00 PM", 300));
        System.out.println(addMinutes.addMinutes("8:44 AM", 12345));
        System.out.println(addMinutes.addMinutes("4:05 PM", 123));
        System.out.println(addMinutes.addMinutes("10:10 AM", 0));
        System.out.println(addMinutes.addMinutes("", 1445));
        System.out.println(addMinutes.addMinutes(null, 1445));
        System.out.println(addMinutes.addMinutes("12:00 GM", 1445));
        System.out.println(addMinutes.addMinutes("12:00 PM", -1445));
    }

    /**
     * Add minutes in given valid input string
     *
     * @param input Input param in valid String format : [H]H:MM {AM|PM}
     * @param min   Input param in Integer format
     * @return Output response in valid String Format : [H]H:MM {AM|PM}
     * @throws EmptyInputException           Empty input exception
     * @throws InvalidMinutesException       Invalid minutes exception
     * @throws InvalidPeriodException        Invalid period exception
     * @throws InvalidHourOrMinutesException Invalid hour or minutes exception
     * @throws Exception                     Other exceptions
     */

    private String addMinutes(String input, Integer min) {

        try {

            // Making sure input string is not empty or null.
            if (input == null || input.equals("")) {
                throw new EmptyInputException("Invalid Input. Please enter input in correct format: [H]H:MM {AM|PM}. \n" +
                        "Please make sure H and M are in number format.");
            }

            // Making sure minute value is not negative.
            if (min < 0) {
                throw new InvalidMinutesException("Invalid Input. Please enter valid minutes");
            }

            //Declare and initialize output variable
            StringBuilder output = new StringBuilder();

            //Split the input String using space " ", to separate time and period
            String[] timeSplit = input.split(" ");

            //Split the time into hour and minutes.
            String[] hourSplit = timeSplit[0].split(":");

            //Lets deal with period first, set the flag to true if its "PM" else it will be false.
            String period = timeSplit[1];

            // Make sure if time-period is valid.
            if (!period.equals("PM") && !period.equals("AM")) {
                throw new InvalidPeriodException("Invalid period value in 12-hour-clock. Valid period values are \"PM\" or \"AM\"");
            }

            boolean isPM = period != null && !period.equals("") && period.equals("PM");

            //Now lets declare two different variable for for hour and minutes
            Integer hour = Integer.parseInt(hourSplit[0]);
            Integer minutes = Integer.parseInt(hourSplit[1]);

            // Make sure if time input are in valid 12-hour-clock format
            if (hour > 12 || minutes > 60) {
                throw new InvalidHourOrMinutesException("Invalid hour/minute value in 12-hour-clock");
            }

            // Lets calculate how many hours added by dividing "input min" by 60
            Integer hoursToBeAdded = min / 60;

            // Lets calculate how many minutes to be added by taking modulo of "input min" by 60
            Integer minutesToBeAdded = min % 60;

            // setting hour to 0 if its 12, this makes it easy for AM PM shift calculations.
            hour = hour == 12 ? 0 : hour;
            // incrementing hour by adding hours to be added
            hour = hour + hoursToBeAdded;

            // incrementing minutes by adding minutes to be added
            minutes = minutes + minutesToBeAdded;

            //At any points after adding minutesToBeAdded in minutes
            // if minutes touches or crosses 60, we will find extra minutes got added using remainder and will increase the hour by 1
            if (minutes >= 60) {
                minutes = minutes % 60;
                hour++;
            }

            //Initialising shift variable to catch AM PM changes
            int shift = 0;

            // If hour value touches or crosses 12, then there is a change of shift from AM to PM or vice versa, so calculating how many shifts will be there
            // Next step is to calculate remaining hours and assigning it to hours
            if (hour >= 12) {
                shift = hour / 12;
                hour = hour % 12;
            }

            // If shift is odd, meaning there is a change to period, but if its even, meaning there no change of shift.
            // Example, if we are adding 1445 minutes to 12:05 AM, it means we are adding 24 hours and 05 minutes
            // After 24 hours shift should remain same, so if 24/12 => 2 which is even
            // Hence if its odd, there is change of shift

            if (shift % 2 != 0) {
                period = isPM ? "AM" : "PM";
            }

            // At the end just append everything to an output

            output.append(hour == 0 ? 12 : hour) // As module by 12 could give 0 if hour is 12, we need to take care of this edge case.
                    .append(":") // Appending ":" as a hour minute separator
                    .append(minutes < 10 ? "0" : "") // Appending 0 if minutes are less than 10 else nothing
                    .append(minutes) // appending minutes
                    .append(" ") // Appending " " as a separator between time and period
                    .append(period); // Finally appending  calculated period as AM or PM

            return output.toString(); // Returning output

        } catch (InvalidPeriodException | InvalidHourOrMinutesException | InvalidMinutesException | EmptyInputException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid Input. Please enter input in correct format: [H]H:MM {AM|PM}. \n" +
                    "Please make sure H and M are in number format.");
        }
        return "INVALID INPUT";
    }


}
