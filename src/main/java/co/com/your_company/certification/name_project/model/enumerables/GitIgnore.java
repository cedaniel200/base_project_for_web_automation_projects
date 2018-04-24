package co.com.your_company.certification.name_project.model.enumerables;

public enum GitIgnore {

    NONE("None"),
    JAVA("Java"),
    ANDROID("Android"),
    C("C"),
    CPlusPlus("C++");

    private final String nameGitIgnore;

    GitIgnore(final String nameGitIgnore) {
        this.nameGitIgnore = nameGitIgnore;
    }

    @Override
    public String toString() {
        return nameGitIgnore;
    }
}
