# Basic Java/Gradle/Eclipse project template

You have just created a basic Java project using the standard Gradle project layout. It provides a basic Gradle build, including support for generating Eclipse project files so that you can import your project into Eclipse. Java source files should be placed into `src/main/java`. You will find an application class (a class with a `public static void main(String[] args)` method) where you can being writing code at `${projectPackageFolder}/${mainClassName}.java`.

## File Locations
- project folder: `${projectDir}`
- main class
	- relative to project folder: `${projectPackageFolder}/${mainClassName}.java`
	- absolute path: `${projectDir}/${projectPackageFolder}/${mainClassName}.java`

## Next steps
- Run `gradle eclipse` to generate Eclipse project configuration files.
- Import the project into Eclipse by selecting *File->Import…*, *General/Existing Projects into Workspace*, then browsing to the `${projectDir}` folder.