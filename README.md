# mhc-utils
## Pacote de utilitários Java mhc.dev.br

### Como utilizar
Para utilizar é muito simples, basta ir no arquivo `pom.xml` do seu projeto, e adicionar as seguintes dependências:

#### Repositório GitHub Packages
Esse trecho permite que o Maven saiba que deve buscar a dependência no GitHub (e não no Maven Central):
```xml
    <repositories>
        <repository>
            <id>github</id>
            <url>https://maven.pkg.github.com/marcelocezario/mhc-utils-java</url>
        </repository>
    </repositories>
```
#### Dependência do pacote
Aqui você define o pacote e a versão a ser utilizada:
```xml
        <dependency>
            <groupId>br.dev.mhc</groupId>
            <artifactId>mhc-utils</artifactId>
            <version>1.0.0</version> <!-- Substitua pela versão mais recente ou LATEST -->
        </dependency>
```
