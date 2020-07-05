package server.poketowns.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;

public class ConfigurationManager {
	
	private static ConfigurationManager instance = new ConfigurationManager();
	
	public static ConfigurationManager getInstance(){
		return instance;
	}
	
	private ConfigurationLoader<CommentedConfigurationNode> configLoader;
	private CommentedConfigurationNode config;
	
	public void setup(Path configFile, ConfigurationLoader<CommentedConfigurationNode> configLoader){
		this.configLoader = configLoader;
		if(!configFile.toFile().exists()){
			try {
				configFile.toFile().createNewFile();
				loadConfig();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			loadConfig();
		}
	}
	
	public CommentedConfigurationNode getConfig(){
		return config;
	}
	
	public void saveConfig(){
		try {
			configLoader.save(config);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadConfig(){
		try {
			config = configLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
