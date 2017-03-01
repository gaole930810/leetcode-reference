package hard;
/*
 * 2016.5.8
 * ���Ͷ�̬�滮����
 * dp[i]��ʾ�Ե�i-1���ַ�Ϊ��β�ĺϷ�������
 * ��ʼ����dp[0]��Ȼ��0��dp[1]��Ϊ��ʱֻ��һ���ַ���һ�����ǺϷ������飬����Ҳ��0
 * �����i-1���ַ��ǣ���ֱ�ӵ���0����Ϊ�����Ų��ܳ�Ϊ�Ϸ�������Ľ�β
 * �����i-1���ַ��ǣ�����һ������ǵ�i-2���ַ��ǣ�����ôֱ��dp[i]=dp[i-2]+2���ɣ����ﲻ�õ���i-2Խ�磬��Ϊdp�Ǵ�0��s.length
 * �ڶ�������ǵ�i-2���ַ��ǣ�����ô���dp[i-1]������0��˵��ǰ���Ǹ����������һ���Ϸ��������飬��ôֻҪ����Ϸ���������ǰ���һ���ַ��ǣ�������
 * ����dp[i]=dp[i-1]+2,���ǻ���������ǣ���i-1���ַ�ƥ��ģ�ǰ���Ǹ��Ϸ��������飬����Ӧ�ü���ǰ��Ϸ�������ĳ���
 * �������յ�dp[i]=dp[i-1]+2+dp[i-2-dp[i-1]];
 */
public class Q32 {
	public int longestValidParentheses(String s) {
		int[] dp=new int[s.length()+1];
		int max=0;
		if(s.length()==0) return max;
		dp[0]=0;
		dp[1]=0;
		for(int i=2;i<dp.length;i++){
			if(s.charAt(i-1)=='('){
				dp[i]=0;
			}else{
				if(s.charAt(i-2)=='('){
					dp[i]=dp[i-2]+2;
				}else if(dp[i-1]!=0){
					if(i-2-dp[i-1]>=0 && s.charAt(i-2-dp[i-1])=='('){
						dp[i]=dp[i-1]+2+dp[i-2-dp[i-1]];
					}
					else dp[i]=0;
				}
			}
			max=dp[i]>max?dp[i]:max;
		}
		return max;
	}
}