package Services;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/services/*")
public class MainApplication extends Application {

     @Override
     public Set<Class<?>> getClasses(){
         HashSet h = new HashSet<Class<?>>();
         h.add(AbsenceService.class);
         return h;

     }


}
