package com.navegi;
import com.badlogicgames.packr.Packr;
import com.badlogicgames.packr.Packr.Config;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;
import java.io.IOException;
import java.util.Arrays;


public class ExeTask extends DefaultTask {
    public String jarPath;
    public String outPut;
    public String mainClass;
    public String jdkPath;
    public String resource;

    @Input
    public String getJarPath() {
        return jarPath;
    }
    @Input
    public String getJdkPath() {
        return jdkPath;
    }
    @Input
    public String getResource() {
        return resource;
    }
    @Input
    public String getOutPut() {
        return outPut;
    }
    @Input
    public String getMainClass() {
        return mainClass;
    }

    @TaskAction
    public void Exe() throws IOException {
        Config config = new Config();
        config.platform = Packr.Platform.windows;
        config.jdk = jdkPath;
        config.jar = jarPath;
        config.executable = "myapp";
        config.mainClass = mainClass;
        config.vmArgs = Arrays.asList("Xmx1G");
        config.minimizeJre = new String[] {"soft"};
        config.outDir = outPut;
        config.resources = Arrays.asList(resource);

        new Packr().pack(config);
    }
}
