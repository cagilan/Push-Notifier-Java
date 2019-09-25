package nsn.mobile.apps.adapter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



import nsn.mobile.apps.nsnnotifier.R;
import nsn.mobile.apps.nsnnotifier.communication.NSNConnect;
import nsn.mobile.apps.nsnnotifier.communication.NSNConnectException;



import android.R.anim;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ArchieveListAdapter extends BaseExpandableListAdapter {
	private Context context;
    private String listdesc[][][][];
    private LayoutInflater inflater;
    private ExpandableListView topExpList;
    public int height;
	private static final String KEY_COLORNAME = "colorName";
    private static final String KEY_SHADENAME = "shadeName";
    private static final String LOG_TAG = "ColorExpListAdapter";


    public ArchieveListAdapter(Context context, 
                            ExpandableListView topExpList,
                            String listdesc[][][][] ,int ret) { 
        this.context = context;
        this.topExpList = topExpList;
        this.height=ret;
        this.listdesc = listdesc;
        inflater = LayoutInflater.from( context );
    }
    
    private int calculateRowCount( int level1,int child, ExpandableListView level2view ) {
//        int level2GroupCount = listdesc[level1][child].length;
//        int rowCtr = 0;
//        for( int i = 0 ; i < level2GroupCount ; ++i ) {
//            ++rowCtr;       // for the group row
//			if( ( level2view != null ) && ( level2view.isGroupExpanded( i ) ) )
//				rowCtr += listdesc[level1][i].length - 1;	// then add the children too (minus the group descriptor)
//        }
        
		return 1;
    }
    private int calculateRowCount2( int level1,int level2 ) {
        return listdesc[level1][level2].length;

    }
//    private List<ArrayList<HashMap<String, String>>> createChildList( int level1 ) {
//	    ArrayList<ArrayList<HashMap<String, String>>> result = new ArrayList<ArrayList<HashMap<String, String>>>();
//	    for( int i = 0 ; i < listdesc[level1].length ; ++i ) {
//// Second-level lists
//	        ArrayList<HashMap<String, String>> secList = new ArrayList<HashMap<String, String>>();
//	        for( int n = 1 ; n < listdesc[level1][i].length ; ++n ) {
//	            HashMap<String, String> child = new HashMap<String, String>();
//		        child.put( KEY_SHADENAME, listdesc[level1][i][n][0] );
//	          //  child.put( KEY_RGB, listdesc[level1][i][n][1] );
//		        secList.add( child );
//	        }
//	        result.add( secList );
//	    }
//	    return result;
//    }
//
//    private List<HashMap<String, String>> createGroupList( int level1 ) {
//        ArrayList<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
//	    for( int i = 0 ; i < listdesc[level1].length ; ++i ) {
//	        HashMap<String, String> m = new HashMap<String, String>();
//	        m.put( KEY_COLORNAME,listdesc[level1][i][0][1] );
//	       
//	    	result.add( m );
//	    }
//	    return result;
//    }
//    
    
//    private String[] creategroup(int level1,int child)
//    {
//    	String level2group[]=new String[listdesc[level1].length];
//    	 for( int i = 0 ; i < listdesc[level1].length ; ++i ) {
// 	       level2group[i]=listdesc[level1][i][0][1];
// 	    }
//    	
//    	return level2group;
//    }
//    
//    private String[][] createchild(int level1)
//    {
//    	String level2child[][]=new String[listdesc[level1].length][];
//    	 for( int i = 0 ; i < listdesc[level1].length ; ++i ) {
//    		level2child[i]=new String[1];
//    		level2child[i][0]=listdesc[level1][i][1][0];
//    		
//    		
//   	    }
//      	
//    	
//    	return level2child;
//    }
    
    
    private String creategroup(int level1,int child)
    {
    	return listdesc[level1][child][0][1];
    }
    
    private String[][] createchild(int level1,int child)
    {
    	String level2child[][]=new String[listdesc[level1][child].length][];
    	
    	
    	
    	
    	
    	 for( int i = 0 ; i < listdesc[level1][child].length ;i++ ) {
    		
    		 
    		 level2child[i]=new String[listdesc[level1][child][i].length];
    		
    		
    		
    		level2child[i]=listdesc[level1][child][i];
    		
    		
   	    }
      	
    	// Toast.makeText(context,level2child.length+"", Toast.LENGTH_SHORT).show();
    	return level2child;
    }
    
    
    
	@Override
	 public Object getChild(int groupPosition, int childPosition) {
        return listdesc[groupPosition][childPosition];
    }

	@Override
	public long getChildId(int groupPosition, int childPosition) {
        return (long)( groupPosition*1024+childPosition );  // Max 1024 children per group
    }

//	@Override
//	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
//        Log.d( LOG_TAG, "getChildView: groupPositon: "+groupPosition+"; childPosition: "+childPosition );
//		View v = null;
////		if( listViewCache[groupPosition] != null )
////            v = listViewCache[groupPosition];
////        else {
//        	//Drawable d=new Drawable(R.drawable.divider);
//            DebugExpandableListView dev = new DebugExpandableListView( context );
//			dev.setRows( calculateRowCount( groupPosition, null ),height );
//		
//			dev.setChildDivider(context.getResources().getDrawable(R.drawable.divider));
//			dev.setDivider(context.getResources().getDrawable(R.drawable.divider));
//			dev.setDividerHeight(1);
//			dev.setGroupIndicator(context.getResources().getDrawable(R.drawable.indicator));
//
//
//			dev.setAdapter( 
//			        new DebugSimpleExpandableListAdapter(
//				        context,
//				        createGroupList( groupPosition ),	// groupData describes the first-level entries
//				        android.R.layout.simple_expandable_list_item_1,	// Layout for the first-level entries
//				        new String[] { KEY_COLORNAME },	// Key in the groupData maps to display
//				        new int[] { android.R.id.text1 },		// Data under "colorName" key goes into this TextView
//				        createChildList( groupPosition ),	// childData describes second-level entries
//				        R.layout.test,	// Layout for second-level entries
//				        new String[] { KEY_SHADENAME },    // Keys in childData maps to display
//				        new int[] { R.id.loading }	// Data under the keys above go into these TextViews
//                    )
//          	);
//            dev.setOnGroupClickListener( new Level2GroupExpandListener( groupPosition ) );
//			//listViewCache[groupPosition] = dev;
//			v = dev;
//		//}
//        return v;
//    }
	
	
	
	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
     
		View v = null;
            DebugExpandableListView dev = new DebugExpandableListView( context );
			dev.setRows( calculateRowCount( groupPosition,childPosition, null ),height );
		
			dev.setChildDivider(context.getResources().getDrawable(R.drawable.divider));
			dev.setDivider(context.getResources().getDrawable(R.drawable.divider));
			dev.setDividerHeight(1);
			dev.setGroupIndicator(context.getResources().getDrawable(R.drawable.indicator));
		//	dev.setGroupIndicator(null);
		//	dev.setId(childPosition);
			dev.setScrollingCacheEnabled(false);
			
//			LayoutParams param=new LayoutParams(LayoutParams.MATCH_PARENT, android.R.attr.listPreferredItemHeight);
//			
//			dev.setLayoutParams(param);
			dev.setAdapter(new ArchivechildAdapter( context, creategroup( groupPosition,childPosition ), createchild( groupPosition,childPosition )));
            dev.setOnGroupClickListener( new Level2GroupExpandListener( groupPosition ) );
            dev.setOnChildClickListener( new Level2ChildExpandListener( groupPosition ) );
	
			v = dev;
	        return v;
    }
	
	
	@Override
	 public int getChildrenCount(int groupPosition) {
        return listdesc[groupPosition].length;
    }


	@Override
	public Object getGroup(int groupPosition) {
        return listdesc[groupPosition][0][0][0];        
    }

	@Override
	public int getGroupCount() {
        return listdesc.length;
    }

	@Override
	public long getGroupId(int groupPosition) {
        return (long)( groupPosition*1024 );  // To be consistent with getChildId
    }

	@Override
	 public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        Log.d( LOG_TAG, "getGroupView: groupPositon: "+groupPosition+"; isExpanded: "+isExpanded );
        View v;// = null;
//        if( convertView != null )
//        { v = convertView;
//        }
//        else
//        {   
        	v = inflater.inflate(android.R.layout.simple_expandable_list_item_1, parent, false);
//        	}
        String gt = (String)getGroup( groupPosition );
		TextView colorGroup = (TextView)v.findViewById(  android.R.id.text1 );
		if( gt != null )
			colorGroup.setText( gt );
		

	//	height=android.R.attr.listPreferredItemHeight;
		//Toast.makeText(context,height+"", Toast.LENGTH_LONG).show();
		return v;
    }

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}
	 public void onGroupCollapsed (int groupPosition) {} 
	    public void onGroupExpanded(int groupPosition) {}
	    
	    
	    
	    
	    
	    
	    class Level2GroupExpandListener implements ExpandableListView.OnGroupClickListener {
			public Level2GroupExpandListener( int level1GroupPosition) {
				this.level1GroupPosition = level1GroupPosition;
				//this.child=child;
			}

	       	public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
	       		if( parent.isGroupExpanded( groupPosition ) )
	       		{
	            	parent.collapseGroup( groupPosition );
	            	if( parent instanceof DebugExpandableListView ) {
	    				
						DebugExpandableListView dev = (DebugExpandableListView)parent;
						dev.setRows( 1,height );
				Toast.makeText(context,groupPosition+"group", Toast.LENGTH_SHORT).show();
					}
	       		
	       		
	       		}
	        	else
	        	{
	           		parent.expandGroup( groupPosition);
					if( parent instanceof DebugExpandableListView ) {
				
						DebugExpandableListView dev = (DebugExpandableListView)parent;
						dev.setRows( calculateRowCount2( level1GroupPosition,groupPosition ),height );
					//	dev.setRows( 10,height );
					Toast.makeText(context,groupPosition+"group", Toast.LENGTH_SHORT).show();
					}
				
	        	}
	          // 	Log.d( LOG_TAG, "onGroupClick" );
	          // 	topExpList.requestLayout();
	          	return true;
	     	}

			private int level1GroupPosition;//,child;
		}
	    class Level2ChildExpandListener implements ExpandableListView.OnChildClickListener {
	    	private int level1ChildPosition;
	    	
	    	
	    	public Level2ChildExpandListener( int level1GroupPosition ) {
				this.level1ChildPosition = level1GroupPosition;
			}

	       			

			@Override
			public boolean onChildClick(ExpandableListView arg0, View arg1,int arg2, int arg3, long arg4) {
				// TODO Auto-generated method stub
			//	Toast.makeText(context,arg2+"", Toast.LENGTH_SHORT).show();
				return true;
			}
		}


}
