package alexiil.mc.mod.load;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

public class Translation {
    private static Map<String,String> map;
    public static String translate(String toTranslate) {
        if (map==null){
            map=new HashMap<>();
            map.put("customloadingscreen.modstate.minecraft_init","Minecraft Initializing");
            map.put("customloadingscreen.modstate.construction","Construction");
            map.put("customloadingscreen.modstate.pre_initialization","Pre Initialization");
            map.put("customloadingscreen.modstate.initialization","Initialization");
            map.put("customloadingscreen.modstate.post_initialization","Post Initialization");
            map.put("customloadingscreen.modstate.completed","Completed");
            map.put("customloadingscreen.modstate.reloading_resource_packs","Reloading Resource Packs");
            map.put("customloadingscreen.mcstate.modelloader.items","Loading Item Models");
            map.put("customloadingscreen.mcstate.modelloader.blocks","Loading Block Models");
            map.put("customloadingscreen.mcstate.modelloader.bake","Baking Models");
            map.put("customloadingscreen.mcstate.texture.load","Loading Textures");
            map.put("customloadingscreen.mcstate.texture.stitch","Stitching Textures");
            map.put("customloadingscreen.loading","loading");
            map.put("customloadingscreen.finishing","Finishing");
        }
        String res=map.get(toTranslate);
        return res==null?toTranslate:res;
    }
}
