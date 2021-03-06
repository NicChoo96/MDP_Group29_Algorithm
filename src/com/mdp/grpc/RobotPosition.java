// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: algocomm.proto

package com.mdp.grpc;

/**
 * <pre>
 * Current robot coordinates to be sent to the rPi.
 * Format is "RP:X:Y:Dir"
 * X = 0 to 19
 * Y = 0 to 19
 * Dir = N, S, E, or W
 * </pre>
 *
 * Protobuf type {@code algo.RobotPosition}
 */
public  final class RobotPosition extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:algo.RobotPosition)
    RobotPositionOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RobotPosition.newBuilder() to construct.
  private RobotPosition(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RobotPosition() {
    robotCoordinates_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RobotPosition(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            robotCoordinates_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.mdp.grpc.Algocomm.internal_static_algo_RobotPosition_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.mdp.grpc.Algocomm.internal_static_algo_RobotPosition_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.mdp.grpc.RobotPosition.class, com.mdp.grpc.RobotPosition.Builder.class);
  }

  public static final int ROBOTCOORDINATES_FIELD_NUMBER = 1;
  private volatile java.lang.Object robotCoordinates_;
  /**
   * <code>string robotCoordinates = 1;</code>
   */
  public java.lang.String getRobotCoordinates() {
    java.lang.Object ref = robotCoordinates_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      robotCoordinates_ = s;
      return s;
    }
  }
  /**
   * <code>string robotCoordinates = 1;</code>
   */
  public com.google.protobuf.ByteString
      getRobotCoordinatesBytes() {
    java.lang.Object ref = robotCoordinates_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      robotCoordinates_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getRobotCoordinatesBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, robotCoordinates_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getRobotCoordinatesBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, robotCoordinates_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.mdp.grpc.RobotPosition)) {
      return super.equals(obj);
    }
    com.mdp.grpc.RobotPosition other = (com.mdp.grpc.RobotPosition) obj;

    boolean result = true;
    result = result && getRobotCoordinates()
        .equals(other.getRobotCoordinates());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ROBOTCOORDINATES_FIELD_NUMBER;
    hash = (53 * hash) + getRobotCoordinates().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.mdp.grpc.RobotPosition parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.mdp.grpc.RobotPosition parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.mdp.grpc.RobotPosition parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.mdp.grpc.RobotPosition parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.mdp.grpc.RobotPosition parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.mdp.grpc.RobotPosition parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.mdp.grpc.RobotPosition parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.mdp.grpc.RobotPosition parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.mdp.grpc.RobotPosition parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.mdp.grpc.RobotPosition parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.mdp.grpc.RobotPosition parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.mdp.grpc.RobotPosition parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.mdp.grpc.RobotPosition prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Current robot coordinates to be sent to the rPi.
   * Format is "RP:X:Y:Dir"
   * X = 0 to 19
   * Y = 0 to 19
   * Dir = N, S, E, or W
   * </pre>
   *
   * Protobuf type {@code algo.RobotPosition}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:algo.RobotPosition)
      com.mdp.grpc.RobotPositionOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.mdp.grpc.Algocomm.internal_static_algo_RobotPosition_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.mdp.grpc.Algocomm.internal_static_algo_RobotPosition_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.mdp.grpc.RobotPosition.class, com.mdp.grpc.RobotPosition.Builder.class);
    }

    // Construct using com.mdp.grpc.RobotPosition.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      robotCoordinates_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.mdp.grpc.Algocomm.internal_static_algo_RobotPosition_descriptor;
    }

    @java.lang.Override
    public com.mdp.grpc.RobotPosition getDefaultInstanceForType() {
      return com.mdp.grpc.RobotPosition.getDefaultInstance();
    }

    @java.lang.Override
    public com.mdp.grpc.RobotPosition build() {
      com.mdp.grpc.RobotPosition result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.mdp.grpc.RobotPosition buildPartial() {
      com.mdp.grpc.RobotPosition result = new com.mdp.grpc.RobotPosition(this);
      result.robotCoordinates_ = robotCoordinates_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.mdp.grpc.RobotPosition) {
        return mergeFrom((com.mdp.grpc.RobotPosition)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.mdp.grpc.RobotPosition other) {
      if (other == com.mdp.grpc.RobotPosition.getDefaultInstance()) return this;
      if (!other.getRobotCoordinates().isEmpty()) {
        robotCoordinates_ = other.robotCoordinates_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.mdp.grpc.RobotPosition parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.mdp.grpc.RobotPosition) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object robotCoordinates_ = "";
    /**
     * <code>string robotCoordinates = 1;</code>
     */
    public java.lang.String getRobotCoordinates() {
      java.lang.Object ref = robotCoordinates_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        robotCoordinates_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string robotCoordinates = 1;</code>
     */
    public com.google.protobuf.ByteString
        getRobotCoordinatesBytes() {
      java.lang.Object ref = robotCoordinates_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        robotCoordinates_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string robotCoordinates = 1;</code>
     */
    public Builder setRobotCoordinates(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      robotCoordinates_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string robotCoordinates = 1;</code>
     */
    public Builder clearRobotCoordinates() {
      
      robotCoordinates_ = getDefaultInstance().getRobotCoordinates();
      onChanged();
      return this;
    }
    /**
     * <code>string robotCoordinates = 1;</code>
     */
    public Builder setRobotCoordinatesBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      robotCoordinates_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:algo.RobotPosition)
  }

  // @@protoc_insertion_point(class_scope:algo.RobotPosition)
  private static final com.mdp.grpc.RobotPosition DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.mdp.grpc.RobotPosition();
  }

  public static com.mdp.grpc.RobotPosition getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RobotPosition>
      PARSER = new com.google.protobuf.AbstractParser<RobotPosition>() {
    @java.lang.Override
    public RobotPosition parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RobotPosition(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RobotPosition> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RobotPosition> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.mdp.grpc.RobotPosition getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

