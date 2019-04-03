package Sports;

public class CalSports {
	private float gender;
	private float grade;
	private float height;
	private float weight;
	private float capacity;
	private float run;
	private float pull;
	private float reach;
	private float jump;
	private float dash;
	public float bmi;
	public String result=null;


	float[] cf1 = new float[]{3400,3350,3300,3150,3000,2900,2800,2700,2600,2500,2400,2300,2200,2100,2000,1960,1920,1880,1840,1800};
	float[] cf2 = new float[] {3450,3400,3350,3200,3050,2950,2850,2750,2650,2550,2450,2350,2250,2150,2050,2010,1970,1930,1890,1850};
	float[] rf1 = new float[] {(float) 25.8,24,(float) 22.2,21,(float) 19.5,(float) 18.2,(float) 16.9,(float) 15.6,(float) 14.3,13,(float) 11.7,(float) 10.4,(float) 9.1,(float) 7.8,(float) 6.5,(float) 5.7,(float) 4.9,(float) 4.1,(float) 3.3,(float) 2.5};
	float[] rf2 = new float[] {(float) 26.3,(float) 24.4,(float) 22.4,21,(float) 19.5,(float) 18.2,(float) 16.9,(float) 15.6,(float) 14.3,13,(float) 11.7,(float) 10.4,(float) 9.1,(float) 7.8,(float) 6.5,(float) 5.7,(float) 4.9,(float) 4.1,(float) 3.3,(float) 2.5};
	float[] jf1 = new float[] {207,201,195,188,181,178,175,172,169,166,163,160,157,154,151,146,141,136,131,126};
	float[] jf2 = new float[] {208,202,196,189,182,179,176,173,170,167,164,161,158,155,152,147,142,137,132,127};
	float[] pf1 = new float[] {56,54,52,49,46,44,42,40,38,36,34,32,30,28,26,24,22,20,18,16};
	float[] pf2 = new float[] {57,55,53,50,47,45,43,41,39,37,35,33,31,29,27,25,23,21,19,17};
	float[] ruf1 = new float[] {198,204,210,217,224,229,234,239,244,249,254,259,264,269,274,284,294,304,314,324};
	float[] ruf2 = new float[] {196,202,208,215,222,227,232,237,242,247,252,257,262,267,272,282,292,302,312,322};
	float[] df1 = new float[] {(float)7.5,(float) 7.6,(float) 7.7,(float) 8,(float) 8.3,(float) 8.5,(float) 8.7,(float) 8.9,(float) 9.1,(float) 9.3,(float) 9.5,(float) 9.7,
			(float) 9.9,(float) 10.1,(float) 10.3,(float) 10.5,(float) 10.7,(float) 10.9,(float) 11.1,(float) 11.3};
	float[] df2 = new float[] {(float) 7.4,(float) 7.5,(float) 7.6,(float) 7.9,(float) 8.2,(float) 8.4,(float) 8.6,(float) 8.8,(float) 9,(float) 9.2,(float) 9.4,(float) 9.6,(float) 9.8,
			(float) 10,(float) 10.2,(float) 10.4,(float) 10.6,(float) 10.8,(float) 11,(float) 11.2};
	
	float[] cm1 = new float[] {5040,4920,4800,4550,4300,4180,4060,3940,3820,3700,3580,3460,3340,3220,3100,2940,2780,2620,2460,2300};
	float[] cm2 = new float[] {5140,5020,4900,4650,4400,4280,4160,4040,3920,2800,3680,2560,3440,3320,3200,3030,2860,2690,2520,2350};
	float[] rm1 = new float[] {(float) 24.9,(float) 23.1,(float) 21.3,(float) 19.5,(float) 17.7,(float) 16.3,(float) 14.9,(float) 13.5,(float) 12.1,(float) 10.7,(float) 9.3,
			(float) 7.9,(float) 6.5,(float) 5.1,(float) 3.7,(float) 2.7,(float) 1.7,(float) 0.7,(float) -0.3,(float) -1.3};
	float[] rm2 = new float[] {(float) 25.1,(float) 23.3,(float) 21.5,(float) 19.9,(float) 18.2,(float) 16.8,(float) 15.4,(float) 14.0,(float) 12.6,(float) 11.2,(float) 9.8,
			(float) 8.4,(float) 7.0,(float) 5.6,(float) 4.2,(float) 3.2,(float) 2.2,(float) 1.2,(float) 0.2,(float) -0.8};
	float[] jm1 = new float[] {273,268,263,256,248,244,240,236,232,228,224,220,216,212,208,203,198,193,188,183};
	float[] jm2 = new float[] {275,270,265,258,250,246,242,238,234,230,226,222,218,214,210,205,200,195,190,185};
	float[] pm1 = new float[] {19,18,17,16,15,15,14,14,13,13,12,12,11,11,10,9,8,7,6,5};
	float[] pm2 = new float[] {20,19,18,17,16,16,15,15,14,14,13,13,12,12,11,10,9,8,7,6};
	float[] rum1 = new float[] {197,202,207,214,222,227,232,237,242,247,252,257,262,267,272,292,312,332,352,372};
	float[] rum2 = new float[] {195,200,205,212,220,225,230,235,240,245,250,255,260,265,270,290,310,330,350,370};
	float[] dm1 = new float[] {(float) 6.7,(float) 6.8,(float) 6.9,(float) 7.0,(float) 7.1,(float) 7.3,(float) 7.5,(float) 7.7,(float) 7.9,(float) 8.1,(float) 8.3,(float) 8.5,
			(float) 8.7,(float) 8.9,(float) 9.1,(float) 9.3,(float) 9.5,(float) 9.7,(float) 9.9,(float) 10.1};
	float[] dm2 = new float[] {(float) 6.6,(float) 6.7,(float) 6.8,(float) 6.9,(float) 7.0,(float) 7.2,(float) 7.4,(float) 7.6,(float) 7.8,(float) 8.0,(float) 8.2,(float) 8.4,
			(float) 8.6,(float) 8.8,(float) 9.0,(float) 9.2,(float) 9.4,(float) 9.6,(float) 9.8,10};
	
	
	public CalSports() {
		
	}


	public  CalSports(String gender,String grade, String height,String weight,String capacity,String run,String reach,String jump,String pull,String dash) {

	
			if(this.CheckValues(gender,grade,height,weight,capacity,run,pull,reach,jump,dash)==2) {
				this.gender = 1;
				this.grade = 1;
				this.height = 1;
				this.weight = 0;
				this.capacity = 0;
				this.run = 0;
				this.pull = 0;
				this.reach = 0;
				this.jump = 0;
				this.dash = 0;
				this.result = "0";
			}
			else{
				this.gender = Float.parseFloat(gender);
				this.grade = Float.parseFloat(grade);
				this.height = Float.parseFloat(height);
				this.weight = Float.parseFloat(weight);
				this.capacity = Float.parseFloat(capacity);
				this.run = Float.parseFloat(run);
				this.pull = Float.parseFloat(pull);
				this.reach = Float.parseFloat(reach);
				this.jump = Float.parseFloat(jump);
				this.dash = Float.parseFloat(dash);
				this.result = this.getResults();
	
		}
		}
	
	public String Resr() {
		
		System.out.println(this.result);
		return this.result;
	}
	
	public String Resm() {
		if(Float.parseFloat(this.result)<60) {
			return "0";
		}else if(Float.parseFloat(this.result)>90) {
			return "40";
		}else {
			return "60";
		}
	}
	
	public String Resb() {
		System.out.println(this.bmi);
		return Float.toString(this.bmi);
	}
	
	public int CheckValues(String gender,String grade, String height,String weight,String capacity,String run,String pull,String reach,String jump,String dash) {
		if((gender!="0"&&gender!="1")||height==null||weight==null||capacity==null||pull==null||reach==null||jump==null||dash==null||(grade!="1"&&grade!="2")||run==null) {
			return 1;
		}
		return 0;
	}
	
	public String getResults() {
		String result = null;
		float re = 0;
		
		if(this.gender == 1 ) {
			if(this.grade ==1) {
				re =(float) (re + this.GetScore(cf1, this.capacity,1)*0.15 + this.GetScore(df1, this.dash,2)*0.2 + this.GetScore(rf1, this.reach,1)*0.1 + this.GetScore(jf1, this.jump,1)*0.1 + this.GetScore(pf1, this.pull,1)*0.1+this.getBmi()*0.15+this.GetScore(ruf1, this.run, 2)*0.2);
			}else {
				re =(float) (re + this.GetScore(cf2, this.capacity,1)*0.15 + this.GetScore(df2, this.dash,2)*0.2 + this.GetScore(rf2, this.reach,1)*0.1 + this.GetScore(jf2, this.jump,1)*0.1 + this.GetScore(pf2, this.pull,1)*0.1+this.getBmi()*0.15+this.GetScore(ruf2, this.run, 2)*0.2);
			}
		}else {
			if(this.grade ==1) {
				re =(float) (re + this.GetScore(cm1, this.capacity,1)*0.15 + this.GetScore(dm1, this.dash,2)*0.2 + this.GetScore(rm1, this.reach,1)*0.1 + this.GetScore(jm1, this.jump,1)*0.1 + this.GetScore(pm1, this.pull,1)*0.1+this.getBmi()*0.15+this.GetScore(rum1, this.run, 2)*0.2);
			}else {
				re =(float) (re + this.GetScore(cm2, this.capacity,1)*0.15 + this.GetScore(dm2, this.dash,2)*0.2 + this.GetScore(rm2, this.reach,1)*0.1 + this.GetScore(jm2, this.jump,1)*0.1 + this.GetScore(pm2, this.pull,1)*0.1+this.getBmi()*0.15+this.GetScore(rum2, this.run, 2)*0.2);
			}
		}
		
		result = Float.toString(re);
		return result;
		
				
	}
	
	public int GetScore(float[] array, float test,int flag) {
		int i=0;
		if(flag==1) {
			for(i=0;i<array.length;i++) {
				if(test>=array[i])
					break;
			}
		}else {
			
			for(i=0;i<array.length;i++) {
				if(test<=array[i])
					break;
			}
		}
		
		switch(i) {
		case 0:return 100;
		case 1:return 95;
		case 2:return 90;
		case 3:return 85;
		case 4:return 80;
		case 5:return 78;
		case 6:return 76;
		case 7:return 74;
		case 8:return 72;
		case 9:return 70;
		case 10:return 68;
		case 11:return 66;
		case 12:return 64;
		case 13:return 62;
		case 14:return 60;
		case 15:return 50;
		case 16:return 40;
		case 17:return 30;
		case 18:return 20;
		case 19:return 10;
		default:return 0;
		
		}
	}
	
	
	public int getBmi() {
		this.bmi = this.weight*10000 / (this.height*this.height);
		if(this.gender==1) {
			if(this.bmi>=17.2&&this.bmi<=23.9) {
				return 100;
			}else if(this.bmi<=17.1||(this.bmi>=24.0&&this.bmi<=27.9)) {
				return 80;
			}else {
				return 60;
			}
		}else {
			if(this.bmi>=17.9&&this.bmi<=23.9) {
				return 100;
			}else if(this.bmi<=17.8||(this.bmi>=24.0&&this.bmi<=27.9)) {
				return 80;
			}else {
				return 60;
			}
		}
	}
	
}
