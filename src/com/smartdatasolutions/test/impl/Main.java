package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends MemberFileConverter {

	@Override
	protected MemberExporter getMemberExporter( ) {
		// TODO
		MemberExporter memberExporter = new MemberExporterImpl();
		return memberExporter;
	}

	@Override
	protected MemberImporter getMemberImporter( ) {
		// TODO
		MemberImporter memberImporter = new MemberImporterImpl();
		return memberImporter;
	}

	@Override
	protected List< Member > getNonDuplicateMembers( List< Member > membersFromFile ) {

		// TODO
		List< String > uniqueMemberId = new ArrayList<String>();
		List< Member > uniqueMember = new ArrayList<Member>();
		for (Member member : membersFromFile) {
			if (!uniqueMemberId.contains(member.getId())) {
				uniqueMemberId.add(member.getId());
				uniqueMember.add(member);
			}
		}
		return uniqueMember;
	}

	@Override
	protected Map< String, List< Member >> splitMembersByState( List< Member > validMembers ) {
		// TODO
		Map< String, List< Member >> membersSplitByState = new HashMap<String, List< Member >>();
	    for (Member member : validMembers) {
	        List< Member > membersWithState;
	        if (membersSplitByState.containsKey(member.getState())) {
	           membersWithState = membersSplitByState.get(member.getState());
	        } else {
	           membersWithState = new ArrayList< Member >();
	           membersSplitByState.put(member.getState(), membersWithState);
	        }
	        membersWithState.add(member);
	    }
	    return membersSplitByState;
	}

	public static void main( String[] args ) {
		//TODO

		Main main =new Main();
		try {
			main.convert(new File("Members.txt"), "./output/", "outputFile.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
