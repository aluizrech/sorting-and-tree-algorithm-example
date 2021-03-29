# Descompactando arquivos Zip Java

![alt text](https://coffops.com/wp-content/uploads/2021/03/post.png)

<!-- wp:paragraph -->
<p>Descompactar arquivos zipados utilizando Java.</p>
<!-- /wp:paragraph -->


## Vamos ao algoritmo completo

    String origem = "C:\\Zip\\Examplo.zip";
    String destino = "C:\\Zip\\";
    File file = new File(origem);
    ByteArrayInputStream bis = new ByteArrayInputStream(FileUtils.readFileToByteArray(file));
    ZipInputStream zipStream = new ZipInputStream(bis);
    ZipEntry ze;
    byte buff[] = new byte[16384];
    int readBytes;

    while((ze = zipStream.getNextEntry()) != null) {
        String fileName = destino + ze.getName();
        if(ze.isDirectory()) {
            Files.createDirectories(Paths.get(fileName));
            continue;
        }
        zipStream.readAllBytes();
        FileOutputStream outFile = new FileOutputStream(fileName);
        while((readBytes = zipStream.read(buff)) != -1) {
            outFile.write(buff, 0, readBytes);
        }
        outFile.close();
    }

# Confira o post completo em:
https://coffops.com/descompactando-arquivos-zip-java/

## Autor

From **[COFFOPS](https://coffops.com/)** By **[Luiz Antonio Rech](https://github.com/aluizrech)**

---

