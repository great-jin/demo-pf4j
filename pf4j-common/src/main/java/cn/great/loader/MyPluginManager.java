package cn.great.loader;

import org.pf4j.*;

import java.nio.file.Path;

public class MyPluginManager extends DefaultPluginManager {

    /**
     * construct me with the given classloader
     *
     * @param classLoader
     */
    public MyPluginManager(ClassLoader classLoader) {
        ParentClassLoaderJarPluginLoader.parentClassLoader = classLoader;
        //System.setProperty("pf4j.mode", RuntimeMode.DEPLOYMENT.toString());
        //System.setProperty("pf4j.mode", RuntimeMode.DEVELOPMENT.toString());
    }

    @Override
    protected PluginLoader createPluginLoader() {
        // load only jar plugins
        return new ParentClassLoaderJarPluginLoader(this);
    }

    @Override
    protected PluginDescriptorFinder createPluginDescriptorFinder() {
        // read plugin descriptor from jar's manifest
        return new ManifestPluginDescriptorFinder();
    }

    public static class ParentClassLoaderJarPluginLoader extends JarPluginLoader {
        static ClassLoader parentClassLoader;

        /**
         * @param pluginManager
         */
        public ParentClassLoaderJarPluginLoader(PluginManager pluginManager) {
            super(pluginManager);
        }

        static PluginClassLoader pluginClassLoader;

        @Override
        public ClassLoader loadPlugin(Path pluginPath, PluginDescriptor pluginDescriptor) {
            if (pluginClassLoader == null) {
                pluginClassLoader = new PluginClassLoader(pluginManager, pluginDescriptor, parentClassLoader, ClassLoadingStrategy.APD);
            }
            pluginClassLoader.addFile(pluginPath.toFile());
            return pluginClassLoader;
        }
    }
}