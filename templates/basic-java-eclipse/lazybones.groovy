import uk.co.cacoethes.util.NameType

def projectName = new Object() {
	def hyphenated = {
		projectDir.name.contains('-')?
		projectDir.name:
		transformText(projectDir.name, from: NameType.PROPERTY, to: NameType.HYPHENATED)
	};

	def camelCase = {
		transformText(hyphenated(), from: NameType.HYPHENATED, to: NameType.CAMEL_CASE)
	};

	def asPackageName = {
		transformText(hyphenated(), from: NameType.HYPHENATED, to: NameType.PROPERTY)
	};
}

def mainClassName = "${projectName.camelCase()}App"

def mainClassSource = """\
package ${lazybonesRootPackage}.${projectName.asPackageName()};

public class ${mainClassName} {

	public static void main(String[] args) {
		// write your code here
	}

}
"""

// lazybonesRootPackage should be defined externally
def rootPackageFolder = lazybonesRootPackage.replaceAll(/\./, "/")
def projectPackageFolder = "src/main/java/${rootPackageFolder}/${projectName.asPackageName()}"
new File(projectDir, projectPackageFolder).mkdirs()

def javaAppClassFileName = "${projectPackageFolder}/${mainClassName}.java"
new File(projectDir, javaAppClassFileName) << mainClassSource
println "Java application class file is ${projectPackageFolder}/${mainClassName}.java"

new File(projectDir, ".gitignore") << '''
# lazybones
.lazybones

# eclipse
.project
.classpath
.settings/
bin/

# gradle
.gradle/
build/
'''

processTemplates "README.md", [
	projectDir: projectDir,
	projectPackageFolder: projectPackageFolder,
	mainClassName: mainClassName
	]