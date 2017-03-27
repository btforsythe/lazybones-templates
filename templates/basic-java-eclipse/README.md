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

## TODOs

- [ ] write README.md

- [x] use transformText from LazybonesScript.groovy to transform specified project name to hyphenated (either in external script that calls lazybones OR customized lazybones fork)
- [x] create `*App` class with `main` method
	- [x] name based on project name
	- [x] move to package corresponding to project name

- [x] put root package (org.wecancodeit) into external configuration
	- define via -P: `lazybones create basic-java-eclipse 1.0-SNAPSHOT foo -PlazybonesRootPackage=org.wecancodeit`

- [ ] student workstation configuration
	- ~/.lazybones/config.groovy
		- [ ] add my repository

			```
			bintrayRepositories = [
				"btforsythe/lazybones-templates",
				"pledbrook/lazybones-templates"
			]
			```

	- [ ] external script
		- [ ] [NOT DOING - SRP] use lazybones' --with-git option to initialize project as git repository
		- [ ] run `gradle eclipse` after project creation

- [ ] deploy template to bintray
	- [ ] need user name/API key in home directory
	- [ ] need to add description to template