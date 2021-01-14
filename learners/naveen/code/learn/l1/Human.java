package learn.l1;

public class Human {
	private String name;
	private char gender = 'F';
	private int cash =0 ;
	private Float assets = 0.0f;
	
	enum Event{
		BIRTHDAY,
		ANNIVERSARY,
		FIGHT,
		DIVORSE
	};
	
	public Human(String name,char gender,int cash,Float assets)
	{
		this.name =  name;
		this.gender = gender;
		this.cash = cash;
		this.assets = assets;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Spouse {
		int goodSpouse(String... events) {
			
			for(String event: events) {
                goodSpouse(event);
            }
			return 0;
		}
		
		int goodSpouse(String events)
		{
			  Event event = Event.valueOf(events);
			  switch(event)
			  {
				  case BIRTHDAY:
	                  reduceCash(1);break;
	              case ANNIVERSARY:
	                  reduceCash(2);break;
	              case FIGHT:
	                  reduceCash(5);
	                  break;
	              case DIVORSE:
	                  reduceCash(50);                    
	                  reduceAssets(50);
	                  break;
	              default:
	                  System.out.println("Event provided is not valid, hence no action");

			  }
			  
			  return cash;
			  
		}
		
		 private void reduceCash(int percentage) {
	            cash = cash-(cash*percentage/100);
	        }

	        private void reduceAssets(int percentage) {
	            assets = assets-(assets*percentage/100);
	        }
		
		
		
	}

}
