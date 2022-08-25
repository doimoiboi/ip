public class Deadlines extends Task {
    private String deadline;

    public Deadlines(String input) throws MissingDescriptionException, MissingDeadlineException {
        super();
        try {
            //remove initial command
            String sub = input.substring(9);
            int timeIndex = sub.lastIndexOf("/by");
            //get description part of input string
            if (timeIndex == -1) {
                throw new MissingDeadlineException();
            }
            String description = sub.substring(0, timeIndex - 1);
            this.description = description;
            this.deadline = sub.substring(timeIndex + 4);
        } catch (StringIndexOutOfBoundsException e) {
            throw new MissingDescriptionException();
        }
    }

    public Deadlines(String input, boolean isDone) throws MissingDescriptionException, MissingDeadlineException {
        super(isDone);
        try {
            //remove initial command
            String sub = input.substring(9);
            int timeIndex = sub.lastIndexOf("/by");
            //get description part of input string
            if (timeIndex == -1) {
                throw new MissingDeadlineException();
            }
            String description = sub.substring(0, timeIndex - 1);
            this.description = description;
            this.deadline = sub.substring(timeIndex + 4);
        } catch (StringIndexOutOfBoundsException e) {
            throw new MissingDescriptionException();
        }
    }

    public Deadlines(String description, String deadline, boolean isDone) {
        super(isDone);
        this.description = description;
        this.deadline = deadline;
    }

    @Override
    public String processData() {
        String str;
        if (this.getIsDone()){
            str = String.format("D|true|%s|%s|", this.getDescription(), this.deadline);
        } else {
            str = String.format("D|false|%s|%s|", this.getDescription(), this.deadline);
        }
        return str;
    }

    @Override
    public String toString() {
        String str;
        if (this.getIsDone()){
            str = String.format("[D] %s [X] (by %s)", this.getDescription(), this.deadline);
        } else {
            str = String.format("[D] %s [ ] (by %s)", this.getDescription(), this.deadline);
        }
        return str;
    }
}
