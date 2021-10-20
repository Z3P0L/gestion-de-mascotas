package proyecto_logica2;

public class Vector {
    private int size;
    private int count;
    private Object vector[];

    public Vector(int size) {
        this.size = size;
        this.count = 0;
        this.vector = new Object[this.size];
    }
    
    public boolean Add (Object data)
    {
        if(count<size)
        {
            vector[count]=data;  //guardando en el vector el objeto
            count++;
            return true;
        }
        return false;
    }
    
    public Object Search(String code)
    {
        for (int i = 0; i < count; i++) {
            if(vector[i] instanceof Animal)
    {
        if(((Animal)vector[i]).getCode().equalsIgnoreCase(code))
            return vector[i];
    }
    if(vector[i] instanceof Dog)
    {
        if(((Dog)vector[i]).getCode().equalsIgnoreCase(code))
            return vector[i];
    }
    if(vector[i] instanceof Cat)
    {
        if(((Cat)vector[i]).getCode().equalsIgnoreCase(code))
            return vector[i];
    }
    if(vector[i] instanceof Fish)
    {
        if(((Fish)vector[i]).getCode().equalsIgnoreCase(code))
            return vector[i];
    }
}
        
    return null;
}
    
  public boolean Remove(String code) {   
//buscamos la posicion de la cual tengo que eliminar.
      int pos=-1;
      
      for (int i = 0; i < count; i++) {
        if(vector[i] instanceof Animal) {
            if(((Animal)vector[i]).getCode().equalsIgnoreCase(code))
                pos=i;
        }
        if(vector[i] instanceof Dog) {
            if(((Dog)vector[i]).getCode().equalsIgnoreCase(code))
                pos=i;
        }
        if(vector[i] instanceof Cat) {
            if(((Cat)vector[i]).getCode().equalsIgnoreCase(code))
                pos=i;
        }
        if(vector[i] instanceof Fish) {
            if(((Fish)vector[i]).getCode().equalsIgnoreCase(code))
                pos=i;
        }
      }

      if(pos!=-1) {
        for (int j = pos; j < count-1; j++) {
            vector[j]=vector[j+1];
        }
        vector[count-1]=null;
        count--;
        return true;
    }
    return false;
}
  
  public Object StundentsIn(String code) {
      int StudentsIn = 0;
      
      for (int i = 0; i < count; i++) {
          if(((Matricula)vector[i]).getCourse().getCode().equalsIgnoreCase(code)) {
              StudentsIn++;
          }
      }
      
      return StudentsIn;
  }
  
  public Object[] StudentCourse (String code) {
      //Retorna un objeto vector
      int amount=0, i=0;
      
      while (i < count) {
                 if (((Matricula)(vector[i])).getStudent().getId().equalsIgnoreCase(code)) {
              amount++;
          }
        
        i++;
      }
      
      Object courses[] = new Object[amount];
      
      int pos = 0;
      
      for (int j = 0; j < count; j++) {
          if (((Matricula)(vector[i])).getStudent().getId().equalsIgnoreCase(code)) {
              courses[pos] = ((Matricula)vector[i]).getCourse();
              pos++;
              
          }
      }
      
      return courses;
  }

  public double Total (String code) {
      double total = 0;
      
      int i = 0;
      while (i < count) {
          
          if (((Matricula)(vector[i])).getCourse().getCode().equalsIgnoreCase(code)) {
              total += ((Matricula)vector[i]).getValue();
          }
          
          i++;
      }
      
      return total;
  }
    
    @Override
    public String toString()
    {
        String text = "";
        for (int i = 0; i < count; i++) {            
                text = text + vector[i].toString() + "\n";
            }
        return text;
    }

}