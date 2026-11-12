package psn.Util.Keyword;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({
		ElementType.METHOD,
		ElementType.TYPE,
		ElementType.FIELD,
		ElementType.PARAMETER,
		ElementType.LOCAL_VARIABLE,
		ElementType.ANNOTATION_TYPE,
		ElementType.PACKAGE,
		ElementType.CONSTRUCTOR,
		ElementType.TYPE_USE,
		ElementType.TYPE_PARAMETER,
		ElementType.MODULE
})
public @interface Risk {
}
