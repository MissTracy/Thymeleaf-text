package Application;


import Domain.Puppy;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.TemplateSpec;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import java.time.LocalDate;

/**
 * Hello Thymeleaf
 */
public class TemplateApp
{
    private TemplateEngine templateEngine;

    public static void main( String[] args )
    {
        final TemplateApp app = new TemplateApp();
        app.start();
    }

    private void start(){
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver( configureTemplateResolver() );

        final TemplateSpec templateSpec = createTemplateSpec();

        System.out.println( templateEngine.process(templateSpec, initVariableData( new  Puppy( "Shnookums", LocalDate.of( 2022, 2, 2 ), 40, "beef" ))));
        System.out.println( templateEngine.process(templateSpec, initVariableData( new Puppy( "Versace", LocalDate.of( 1873, 4, 1 ), 32, "chicken" ))));
        System.out.println( templateEngine.process(templateSpec, initVariableData( new Puppy( "Fluffy", LocalDate.now(), 10, "cookies" ))));
    }

    private ITemplateResolver configureTemplateResolver(){
        final FileTemplateResolver resolver = new FileTemplateResolver();
        resolver.setPrefix("src/main/resources/Template/");
        resolver.setSuffix(".txt");
        resolver.setTemplateMode(TemplateMode.TEXT);
        resolver.setCharacterEncoding("UTF8");
        resolver.setCheckExistence(true);
        resolver.setCacheable(false);
        return resolver;
    }

    private TemplateSpec createTemplateSpec(){
        TemplateSpec templateSpec = new TemplateSpec("template", TemplateMode.TEXT);
        return templateSpec;
    }


    private Context initVariableData( Puppy aPuppy ){
        final Context ctx = new Context();
        ctx.setVariable( "puppy", aPuppy );
        return ctx;
    }

}