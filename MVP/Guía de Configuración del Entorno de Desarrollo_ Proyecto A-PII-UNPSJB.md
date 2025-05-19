---

**2\. Guía/Tutorial para Configurar el Entorno y los Proyectos**

## ---

**Guía de Configuración del Entorno de Desarrollo: Proyecto A-PII-UNPSJB**

Repositorio Principal: git@github.com:MiyoBran/A-PII-UNPSJB.git  
(Alternativa HTTPS para clonar: https://github.com/MiyoBran/A-PII-UNPSJB.git)  
Esta guía detalla los pasos para configurar el entorno de desarrollo necesario para trabajar con los proyectos datastructures-library y MVP (y otros relacionados) alojados en el repositorio mencionado.

**1\. Prerrequisitos de Software (Instalación Previa)**

Antes de comenzar, asegúrate de tener instalados los siguientes componentes:

* **Git:** Sistema de control de versiones. [Descargar Git](https://git-scm.com/downloads)  
* **JDK (Java Development Kit) versión 21 LTS:**  
  * Recomendado: Eclipse Adoptium Temurin 21 LTS. [Descargar Adoptium Temurin](https://adoptium.net/temurin/releases/?version=21)  
* **Apache Maven (Opcional, pero recomendado tenerlo standalone):** Herramienta de gestión y construcción de proyectos.  
  * Eclipse incluye una versión embebida, pero tener una instalación global es útil. [Descargar Apache Maven](https://maven.apache.org/download.cgi) (descarga el archivo binario zip/tar.gz).  
* **PostgreSQL:** Sistema gestor de base de datos.  
  * [Descargar PostgreSQL](https://www.postgresql.org/download/) (elige la versión para tu sistema operativo).  
  * Se recomienda instalar también **pgAdmin**, la herramienta de administración gráfica para PostgreSQL.  
* **Scene Builder:** Herramienta de diseño visual para JavaFX FXML.  
  * Descargar desde Gluon: [Scene Builder por Gluon](https://gluonhq.com/products/scene-builder/) (elige la versión más reciente compatible con JavaFX 21).  
* **Eclipse IDE:** Entorno de Desarrollo Integrado.  
  * Recomendado: "Eclipse IDE for Enterprise Java and Web Developers" (o "Eclipse IDE for Java Developers" y luego instalar las herramientas necesarias). Asegúrate de que sea una versión reciente que soporte Java 21 y tenga buena integración con Maven (m2e). [Descargar Eclipse](https://www.eclipse.org/downloads/packages/)

**2\. Configuración Inicial del Entorno**

1. **Instalar JDK 21:** Sigue las instrucciones del instalador de Adoptium Temurin.  
2. **Configurar Variables de Entorno JAVA\_HOME y PATH:**  
   * **JAVA\_HOME**: Apunta al directorio de instalación de tu JDK 21 (ej: C:\\Program Files\\Eclipse Adoptium\\jdk-21.0.x.y-hotspot en Windows o /usr/lib/jvm/temurin-21-jdk en Linux).  
   * **PATH**: Añade la subcarpeta bin de tu JAVA\_HOME al PATH del sistema (ej: %JAVA\_HOME%\\bin o $JAVA\_HOME/bin).  
   * (Si instalaste Maven standalone) **M2\_HOME y PATH para Maven:** Similarmente, configura M2\_HOME al directorio de Maven y añade %M2\_HOME%\\bin o $M2\_HOME/bin al PATH.  
   * Verifica con java \-version y mvn \-version en una nueva terminal.  
3. **Instalar PostgreSQL:** Sigue las instrucciones del instalador. Durante la instalación, se te pedirá una contraseña para el superusuario postgres. Anótala.  
4. **Crear Base de Datos y Usuario para el Proyecto MVP:**  
   * Abre pgAdmin (o usa la línea de comandos psql).  
   * Conéctate a tu servidor PostgreSQL.  
   * Crea una nueva base de datos:  
     * Nombre: mvp\_db  
   * Crea un nuevo rol/usuario para la aplicación:  
     * Nombre de usuario: mvp\_user  
     * Contraseña: ciotech (como se usó en el persistence.xml)  
   * Otorga todos los privilegios sobre la base de datos mvp\_db al usuario mvp\_user.  
     SQL  
     \-- Ejemplo de comandos SQL (ejecutar como superusuario postgres)  
     CREATE DATABASE mvp\_db;  
     CREATE USER mvp\_user WITH PASSWORD 'ciotech';  
     GRANT ALL PRIVILEGES ON DATABASE mvp\_db TO mvp\_user;  
     \-- Es posible que también necesites conectarte a mvp\_db y otorgar privilegios sobre esquemas/tablas  
     \-- ALTER USER mvp\_user CREATEDB; \-- Si quieres que el usuario pueda crear BDs (opcional)

5. **Instalar Scene Builder:** Sigue las instrucciones del instalador. Recuerda la ruta de instalación del ejecutable.

**3\. Configuración de Eclipse IDE**

1. **Abrir Eclipse:** Lanza el IDE.  
2. **Configurar JDK Predeterminado en Eclipse:**  
   * Ve a Window \> Preferences (en Windows/Linux) o Eclipse \> Settings... (en macOS).  
   * Navega a Java \> Installed JREs.  
   * Haz clic en Add..., selecciona "Standard VM", y navega al directorio raíz de tu JDK 21 instalado. Confirma.  
   * Asegúrate de que este JDK 21 esté marcado (✓) como el predeterminado.  
3. **Configurar Nivel de Compilación de Java:**  
   * En Window \> Preferences, navega a Java \> Compiler.  
   * Establece "Compiler compliance level" en 21\.  
4. **Verificar Integración de Maven (m2e):**  
   * m2e usualmente viene preinstalado.  
   * (Opcional) En Window \> Preferences \> Maven \> Installations, puedes verificar la versión de Maven que Eclipse está usando o añadir tu instalación standalone de Maven.  
   * (Opcional) En Window \> Preferences \> Maven \> User Settings, puedes configurar la ubicación de tu archivo settings.xml de Maven y tu repositorio local (.m2), aunque los valores por defecto suelen funcionar bien.  
5. **Configurar Scene Builder en Eclipse:**  
   * **Método 1 (File Associations \- General):**  
     * Window \> Preferences \> General \> Editors \> File Associations.  
     * Añade o selecciona el tipo de archivo \*.fxml.  
     * En "Associated editors", haz clic en Add..., selecciona "External programs", y navega hasta el ejecutable de Scene Builder. Hazlo el editor predeterminado si lo deseas.  
   * **Método 2 (Si tienes e(fx)clipse instalado):**  
     * El plugin e(fx)clipse se puede instalar desde Help \> Eclipse Marketplace... (busca "e(fx)clipse").  
     * Una vez instalado, ve a Window \> Preferences \> JavaFX.  
     * En el campo "SceneBuilder executable", introduce la ruta completa al ejecutable de Scene Builder.

**4\. Obtener y Configurar los Proyectos desde Git**

1. **Clonar el Repositorio:**  
   * Abre una terminal Git y navega al directorio donde quieres guardar tus proyectos.  
   * Ejecuta: git clone git@github.com:MiyoBran/A-PII-UNPSJB.git  
   * Esto creará una carpeta A-PII-UNPSJB con todos los proyectos.  
   * (Alternativamente, usa la interfaz de Git de Eclipse para clonar).  
2. **Importar Proyectos Maven en Eclipse:**  
   * En Eclipse, ve a File \> Import....  
   * Selecciona Maven \> Existing Maven Projects. Haz clic en Next.  
   * En "Root Directory", haz clic en Browse... y navega hasta la carpeta A-PII-UNPSJB que acabas de clonar.  
   * Eclipse debería detectar los proyectos Maven (datastructures-library, MVP, tp1, plantilla-maven, etc.) listados en el pom.xml. Selecciónalos todos los que necesites para tu trabajo actual (al menos datastructures-library y MVP).  
   * Haz clic en Finish. Eclipse importará los proyectos y configurará las dependencias según los pom.xml.  
3. **Construir e Instalar datastructures-library Localmente:**  
   * Este paso es **crucial** porque MVP depende de datastructures-library, y esta última es un artefacto local.  
   * En Eclipse, en el "Package Explorer", haz clic derecho sobre el proyecto datastructures-library.  
   * Selecciona Run As \> Maven build... (el que tiene los tres puntos).  
   * En el campo "Goals", escribe: clean install  
   * Haz clic en Run.  
   * Verifica en la consola de Eclipse que la construcción termine con \[INFO\] BUILD SUCCESS.  
4. **Actualizar y Probar el Proyecto MVP:**  
   * Haz clic derecho en el proyecto MVP \-\> Maven \> Update Project... (Alt+F5). Marca "Force update..." y OK.  
   * Para ejecutar la aplicación JavaFX:  
     * Clic derecho en MVP \-\> Run As \> Maven build... \-\> Goals: javafx:run.  
   * Para ejecutar pruebas JUnit:  
     * Navega a src/test/java, haz clic derecho en una clase de prueba o paquete \-\> Run As \> JUnit Test.

**5\. Verificación y Primeros Pasos**

* Si la configuración es correcta, la aplicación MVP (con JavaFX) debería lanzarse.  
* La primera vez que se inicialice la persistencia (ejecutando código que use JpaUtil y ProductoDao), Hibernate intentará crear/actualizar la tabla productos en tu base de datos mvp\_db debido a hibernate.hbm2ddl.auto="update" en persistence.xml. Puedes verificarlo con pgAdmin.  
* Las pruebas JUnit para ProductoDao deberían pasar, indicando que la conexión a la BD y las operaciones básicas funcionan.

---

