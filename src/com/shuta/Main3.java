package com.shuta;

import java.util.Arrays;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 main3=new Main3();
		int[] num={32,21,43,19,28,76,43,35};
	//	main3.bubbleSort(num);
	//	main3.insertSort(num);
	//	main3.simpleChooseSort(num);
	//	main3.mergeSort(num);
	//	main3.quickSort(num,0 , num.length);
		main3.stackSort(num);
	}
	/*
	 * ð������(�Ľ��棬������ѭ���Ĵ���)
	 */
	public void bubbleSort(int []num){
		int len=num.length;
		boolean flag=false;
		for(int i=0;i<len;i++){
			flag=false;
			for(int j=0;j+1<len-i;j++){
				if(num[j]>num[j+1]){
					int temp=num[j];
					num[j]=num[j+1];
					num[j+1]=temp;
					flag=true;
				}
			}
			if(!flag) break;
			System.out.println(Arrays.toString(num));
		}
	}
	/*
	 * ֱ�Ӳ�������
	 */
	public void insertSort(int []num){
		int len=num.length;
		int i=0;
		int j=0;
		for(j=1;j<len;j++){
			for( i=j-1;i>=0;i--){
				if(num[j]>=num[i]) break;
			}
			int insert=i+1;
			if(insert!=j) {
				int val=num[insert];
				num[insert]=num[j];
				for(;insert+1<=j;insert++){
					int temp=num[insert+1];
					num[insert+1]=val;
					val=temp;
				}				
			}		
			System.out.println(Arrays.toString(num));
		}
	}
	/*
	 * ��������
	 */
	public void quickSort(int []num,int i,int j){
		if(j-i<=1) return;
		else{
			int medium=partition(num,i,j);
			
			quickSort(num, i, medium);
			
			
			quickSort(num, medium+1, j);
		}
		
	}
	public int partition(int []num,int i,int j){
		
		int target=num[i];
		int m=i;
		while(i<=j){
			
			while(num[++i]<target){}
			
			while(num[--j]>target){}
			
			if(i<=j){
				int temp=num[i];
				num[i]=num[j];
				num[j]=temp;
			}else{
				int temp=num[j];
				num[j]=target;
				num[m]=temp;
				break;
			}
			
		}
		System.out.println(Arrays.toString(num));
		return j;
	}
	/*
	 * ϣ������
	 */
	public void shellSort(int[] num){
		int len=num.length;
		for(int i=2;len/i>=1;i=i*2){
			for(int j=0;j<len;j=j+i){
				
			}
		}
	}
	/*
	 * ��·�ϲ�����
	 */
	public void mergeSort(int[] num){
		int len=num.length;
		int size=1;
		int i1,j1,i2,j2;
		while(size<len){
			i1=0;
			while(i1+size<len){
				i2=i1+size;
				j1=i2-1;
				if(i2+size<len) j2=i2+size-1;
				else j2=len-1;
				twoRoad(num,i1,j1,i2,j2);
				i1=j2+1;
			}
			System.out.println(Arrays.toString(num));
			size*=2;
		}
		System.out.println(Arrays.toString(num));
	}
	public void twoRoad(int[]num,int i1,int j1,int i2,int j2) {
		int begin=i1;
		int l=j2-i1;
		int[]temp=new int[j2-i1+1];
		int k=0;
		while(i1<=j1&&i2<=j2){
			if(num[i1]<num[i2])	temp[k++]=num[i1++];
			else temp[k++]=num[i2++];		
		}
		
		while(i1<=j1){
			temp[k++]=num[i1++];
		}
		while(i2<=j2){
			temp[k++]=num[i2++];
		}
		for(k=0;k<=l;k++){
			num[begin+k]=temp[k];
		}

	}
	/*
	 * ��ѡ������
	 */
	public void simpleChooseSort(int[] num){
		int len=num.length;
		for(int i=0;i<len;i++){
			int small=num[i];
			int tag=i;
			int j=i;
			for(j=i+1;j<len;j++){
				if(small>num[j]) {
					small=num[j];
					tag=j;
				}
			}
			num[tag]=num[i];
			num[i]=small;
			System.out.println(Arrays.toString(num));
		}
	}
	/*
	 * ������
	 */
	public void stackSort(int[] num){
		int len=num.length;
		int parent=0;
	
		for(int i=len;i>0;i--){
			makeBigStack(num,i);
			//�Ѷ���Զ������
			int temp=num[0];
			num[0]=num[i-1];
			num[i-1]=temp;
			System.out.println(Arrays.toString(num));
	
			
		}
	}
	public void makeBigStack(int[] num,int l){
		for(int i=0;i*2+1<l;i++){
			modifyBigStack(num, i, l);
		}
	}
	public void modifyBigStack(int[]num,int parent,int l){
		if(parent>=0){
			
			int left=2*parent+1;
			int right=2*parent+2;
			int max=num[parent];
			int m_ponit=parent;
			if(left<l&&num[left]>max){
				max=num[left];
				m_ponit=left;
			}
			if(right<l&&num[right]>max){
				max=num[right];
				m_ponit=right;
			}
			if(m_ponit!=parent){
				//�������ˣ�Ҫ��������
				int temp=num[parent];
				num[parent]=max;
				num[m_ponit]=temp;
				modifyBigStack(num, (parent-1)/2,l);
			}
		}		
	}
}
