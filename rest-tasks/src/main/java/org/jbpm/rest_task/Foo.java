package org.jbpm.rest_task;

/**
 * This class was automatically generated by the data modeler tool.
 */
public class Foo  implements java.io.Serializable {

static final long serialVersionUID = 1L;
    
    @org.kie.api.definition.type.Position(value = 0)
    private org.jbpm.rest_task.Bar bar;

    public Foo() {
    }

    public Foo(org.jbpm.rest_task.Bar bar) {
        this.bar = bar;
    }


    
    public org.jbpm.rest_task.Bar getBar() {
        return this.bar;
    }

    public void setBar(  org.jbpm.rest_task.Bar bar ) {
        this.bar = bar;
    }
}