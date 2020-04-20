package wizut.tpsi.springlab1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorController {
    @RequestMapping("/add")
    public String add(Model model, Integer x, Integer y) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        Integer z=x+y;
        model.addAttribute("z", z);
        return "add";
    }
    
    @RequestMapping("/action")
    public String action(Model model,CalculatorForm calc)
    {
        model.addAttribute("x", calc.getX());
        model.addAttribute("y", calc.getY());
        model.addAttribute("action", calc.getAction());
        double z=0;
        switch(calc.getAction())
        {
            case "+":
            {
                z=calc.getX()+calc.getY();
                break;
            }
            case "-":
            {
                z=calc.getX()-calc.getY();
                break;
            }
            case "*":
            {
                z=calc.getX()*calc.getY();
                break;
            }
            case "/":
            {
                if(calc.getY()==0)
                {
                    return "err"; 
                }
                else
                {
                     z=(double)calc.getX()/(double)calc.getY();
                }
            }
        }
        
        model.addAttribute("z", z);
        return "action";
    }
}