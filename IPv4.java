public class IPv4
{
	final static int version;
	int hLen;
	int length;
	int flags; 				// assume no fragmentation
	int ttl; 				// assume TTL = 50
	String protocol;		// assume TCP
	String checkSum; 		// stores checksum value
	String sourceAddr;		// ip of my choice
	String destinationAddr; // use ip address of the server
	String data;			// May use zeros or random data 

	public IPv4 ( )
	{
		hLen = -1;
		length = -1;
		flags = -1;
		ttl = -1;
		protocol = "";
		checkSum = "";
		sourceAddr = "";
		destinationAddr = "";
		data = "";
	}
	public IPv4 ( int hLen, int length, int flags, int ttl, String protocol,
				  String checkSum, String sourceAddr, String destinationAddr,
				  String data )
	{
		this.hLen = hLen;
		this.length = length;
		this.flags = flags;
		this.ttl = ttl;
		this.protocol = protocol;
		this.checkSum = checkSum;
		this.sourceAddr = sourceAddr;
		this.destinationAddr = destinationAddr;
		this.data = data;
	}
	/* setters */
	public void setHlen ( int hLen )
	{ this.hLen = hLen; }
	public void setLength ( int length )
	{ this.length = length; }
	public void setFlags ( int flags )
	{ this.flags = flags; }
	public void setTTL ( int ttl )
	{ this.ttl = ttl; }
	public void setProtocol ( String protocol )
	{ this.protocol = protocol; }
	public void setCheckSum ( String checkSum )
	{ this.checkSum = checkSum; }
	public void setSourceAddr ( String sourceAddr )
	{ this.sourceAddr = sourceAddr; }
	public void setDestinationAddr ( String destinationAddr )
	{ this.destinationAddr = destinationAddr; }
	public void setData ( String data )
	{ this.data = data; }
	
	/* getters */
	public int getHLen ()
	{ return hLen; }
	public int getLength ()
	{ return length; }
	public int getFlags ()
	{ return flags; }
	public int getTTL ()
	{ return ttl; }
	public String getProtocol ()
	{ return protocol; }
	public String getCheckSum ()
	{ return checkSum; }
	public String getSourceAddr ()
	{ return sourceAddr; }
	public String getDestinationAddr ()
	{ return destinationAddr; }
	public String getData ()
	{ return data; }
}