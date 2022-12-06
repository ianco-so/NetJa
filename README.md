# NetJa
Trabalho Final de EDB-II
## TECNOLOGIAS UTILIZADAS
Java JDK 11

## INSTALAÇÕES
### Instalar o Java JDK 11 (Recomendo o do RedHat x64 MSI)

https://developers.redhat.com/products/openjdk/download

Atentar para ativar TUDO na instalação, o PATH e etc.

### Instalar o MAVEN

Escolher a versão Binary zip archive

https://maven.apache.org/download.cgi

Tutorial de como instalar o Maven e colocar as variáveis de ambiente

https://dicasdejava.com.br/como-instalar-o-maven-no-windows/

### IDE

Recomendo o VSCode + [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

https://code.visualstudio.com/download

## RODANDO A APLICAÇÃO
Acesse o diretório do projeto e rode o seguinte comando

`mvn package`

Após isso, ele vai gerar um JAR dentro da pasta `target`.

Entre na pasta `target`.

No seu terminal de preferência, rode o comando:

`java -jar NetJa-1.0-SNAPSHOT.jar {caminhoAbsolutoDoArquivo}`

Note que se você não especificar o caminho absoluto do arquivo, ele não irá rodar, mostrando uma mensagem de falha apropriada.

## COLABORADORES

Este trabalho foi realizado por [@ianco-so](https://github.com/ianco-so) e [@fawnbr](https://github.com/fawnbr) .